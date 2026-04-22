# TakeHome - Clean Architecture Android Project

A multi-module Android project following Clean Architecture principles with Material Design 3 and Jetpack Compose.

## Project Structure

### Module Dependency Graph

```
app  ──→  main  ───────────────────┬──→ domain
  │         │                      │    ↑
  │         │                      ├──→ data  ←── data-remote
  │         │                      │
  ├─────→ presentation  ←──────────┘
  │         │
  ├─────→ design
  │
  ├─────→ common ─── all layers
  │
  └─────→ commonKotlin ─── all layers
```

### Modules

| Module | Type | Purpose |
|--------|------|---------|
| `:app` | Android App | Entry point, MainActivity, Application class |
| `:main` | Android Lib | DI wiring with Koin, TakeHome singleton |
| `:presentation` | Android Lib | Compose screens, ViewModels, MVI features |
| `:design` | Android Lib | Material3 theme, navigation, shared composables |
| `:common` | Android Lib | MVI base classes, REST utilities (OkHttp, Retrofit), Koin setup |
| `:commonKotlin` | JVM Lib | Pure Kotlin: Result, FlowUseCase, coroutines test helpers |
| `:domain` | JVM Lib | Entities, repository interfaces, use cases (zero dependencies) |
| `:data` | JVM Lib | Repository implementations, data source interfaces |
| `:data-remote` | JVM Lib | Retrofit APIs, DTOs with `toDomain()` mappers, remote data sources |

## Architecture Principles

### 1. Clean Architecture
- **Domain layer** has **ZERO** external dependencies (no Retrofit, Android, or Compose)
- Domain defines contracts that lower layers implement
- All flow goes from presentation → domain → data → remote

### 2. Repository Pattern
```
Domain:        SampleRepository (interface)
Data:          SampleRepositoryImpl (impl) + SampleRemoteDataSource (interface)
Data-Remote:   SampleRemoteDataSourceImpl (impl) + DTOs with toDomain() mappers
```

### 3. Use Cases
Every use case:
- Is a class extending `FlowUseCase<Params, Result>` (from commonKotlin)
- Receives `repository` + `CoroutineDispatcher` via constructor
- Returns `Flow<Result<T>>` where Result is Success/Failure

```kotlin
class GetSampleDataUseCase(
    private val repository: SampleRepository,
    dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Result<List<SampleEntity>>>(dispatcher) {
    override fun execute(params: Unit) = repository.getSampleData()
}
```

### 4. MVI Pattern for Presentation
Every feature screen has:
- **State** (extends `UIState`): Data to display
- **Effect** (extends `UIEffect`): One-shot events
- **ViewModel** (extends `ViewModel<State, Effect>`): Manages state/effects via StateFlow/SharedFlow

```kotlin
data class SampleState(val items: List<SampleEntity>) : UIState
sealed class SampleEffect : UIEffect { 
    data class ShowError(val message: String) : SampleEffect()
}

class SampleViewModel(useCase: GetSampleDataUseCase) 
    : ViewModel<SampleState, SampleEffect>(SampleState()) { ... }
```

### 5. Type-Safe Navigation
All routes are `@Serializable` data classes:

```kotlin
@Serializable
object SampleRoute

// In NavHost
composable<SampleRoute> { SampleScreen() }
```

### 6. Collectible Effects
**Always use `when` in effect handlers** (never `if`):

```kotlin
CollectAsEffect(viewModel.effect) { effect ->
    when (effect) {
        is SampleEffect.ShowError -> showErrorDialog(effect.message)
        SampleEffect.DataLoaded -> {}
    }
}
```

## DI Wiring (Koin)

### Module Loading Order
1. `commonModule` (OkHttpClient)
2. `dataRemoteModule` (Retrofit APIs)
3. `dataModule` (Repositories, DataSources)
4. `domainModule` (Use cases with Dispatchers)
5. `presentationModule` (ViewModels)

```kotlin
// In TakeHome.init()
startKoin {
    modules(
        commonModule,
        dataRemoteModule,
        dataModule,
        domainModule,
        presentationModule
    )
}
```

### ViewModel Injection
Screens use `koinViewModel()`:

```kotlin
@Composable
fun SampleScreen(viewModel: SampleViewModel = koinViewModel()) { ... }
```

## How to Add a New Feature

### Step 1: Define Domain Layer
Create in `:domain/com/ctb/domain/`:
- `models/YourEntity.kt` (data class)
- `repositories/YourRepository.kt` (interface)
- `usecase/YourUseCase.kt` (extends FlowUseCase)

```kotlin
class GetYourDataUseCase(
    private val repository: YourRepository,
    dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Result<List<YourEntity>>>(dispatcher) {
    override fun execute(params: Unit) = repository.getData()
}
```

### Step 2: Implement Data Layer
Create in `:data/com/ctb/data/`:
- `datasource/YourRemoteDataSource.kt` (interface)
- `repository/YourRepositoryImpl.kt` (implements domain interface)

### Step 3: Add Remote Data Source
Create in `:data-remote/com/ctb/data_remote/`:
- `api/YourApi.kt` (Retrofit interface)
- `response/YourResponse.kt` (DTO with `toDomain()`)
- `repository/YourRemoteDataSourceImpl.kt` (implements data interface)

```kotlin
data class YourResponse(...) 
fun YourResponse.toDomain() = YourEntity(...)
```

### Step 4: Create Presentation Feature
Create in `:presentation/com/ctb/presentation/yourfeature/`:
- `YourRoute.kt` (@Serializable route object)
- `YourState.kt` (data class extends UIState)
- `YourEffect.kt` (sealed class extends UIEffect)
- `YourViewModel.kt` (extends ViewModel<State, Effect>)
- `YourContent.kt` (composable preview)
- `YourScreen.kt` (uses koinViewModel)

```kotlin
@Serializable
object YourRoute

data class YourState(val items: List<YourEntity>) : UIState
sealed class YourEffect : UIEffect { ... }

class YourViewModel(useCase: GetYourDataUseCase) 
    : ViewModel<YourState, YourEffect>(YourState()) { ... }

@Composable
fun YourScreen(vm: YourViewModel = koinViewModel()) { ... }
```

### Step 5: Wire in `:main`
In `main/src/main/kotlin/com/ctb/main/di/`:
- Add to `DomainModule.kt`: factory for your use case
- Add to `DataModule.kt`: single for your repository
- Add to `DataRemoteModule.kt`: if using new API
- Add to `PresentationModule.kt`: viewModel for your screen

### Step 6: Register Navigation Route
In `TakeHomeNavHost.kt` (`:design`):

```kotlin
composable<YourRoute> { YourScreen() }
```

### Step 7: Verify DI Graph
Run the test:
```bash
./gradlew :main:test --tests "CheckTakeHomeModules"
```

Must pass with no errors.

## Testing

### Test Dependencies
- **JUnit 4.13** for all layers
- **MockK 1.13** for mocking
- **Turbine 1.0** for Flow testing (presentation only)
- **Koin Test** for DI verification

### Example: Test a Use Case
```kotlin
@get:Rule
val coroutinesRule = CoroutinesTestRule()

@Test
fun testGetData() = runTest {
    val mockRepository = mockk<SampleRepository>()
    coEvery { mockRepository.getSampleData() } returns flow {
        emit(Result.Success(listOf(sampleEntity)))
    }
    
    val useCase = GetSampleDataUseCase(mockRepository, coroutinesRule.testDispatcher())
    useCase(Unit).collect { result ->
        assert(result is Result.Success)
    }
}
```

## Build & Run

```bash
# Build the project
./gradlew build

# Run tests
./gradlew test

# Verify DI graph
./gradlew :main:test

# Run app on device
./gradlew :app:installDebug

# Clean
./gradlew clean
```

## Key Files

- `settings.gradle.kts` — Module declarations
- `gradle.properties` — Dependency versions
- `main/src/main/kotlin/com/ctb/main/TakeHome.kt` — Koin initialization
- `main/src/main/kotlin/com/ctb/main/di/` — All Koin modules
- `app/src/main/kotlin/com/ctb/takehome/TakeHomeApp.kt` — Application class
- `design/src/main/kotlin/com/ctb/design/navigation/TakeHomeNavHost.kt` — Navigation setup

## Global Architecture Rules

1. ✅ **Domain Zero Deps** — No Retrofit, Android, or Compose imports
2. ✅ **No Feature-to-Feature Imports** — All wiring via `:main` Koin modules
3. ✅ **Repository Pattern** — Interface in domain, impl in data, remote in data-remote
4. ✅ **Use Case Dispatcher** — All use cases receive CoroutineDispatcher
5. ✅ **MVI State/Effect** — StateFlow for state, SharedFlow for one-shot effects
6. ✅ **Kotlin When** — Never use `if` in effect handlers
7. ✅ **Type-Safe Routes** — All navigation via `@Serializable` classes
8. ✅ **DTOs with Mappers** — `toDomain()` extensions in data-remote layer
9. ✅ **Koin Verify** — DI graph passes `CheckTakeHomeModules` test

---

**Generated with Clean Architecture principles and Kotlin best practices.**
