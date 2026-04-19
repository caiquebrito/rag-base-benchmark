# DI Wiring

## Config

- **Package:** `com.ctb.main`
- **Type:** Android Library
- **Dependencies:** `:domain`, `:data`, `:data-remote`, `:common`, `:commonKotlin`, `:presentation` + OkHttp, Koin

## Structure

```
com.ctb.main/
├── TakeHome.kt           — Public init(baseURL, isDebug) entry point
├── TakeHomeModule.kt     — All Koin modules wired together
└── CheckTakeHomeModules.kt — Koin graph verification test (in test/)
```

## Rules

1. Single point where all layers are connected. No UI, no business logic.
2. `TakeHome.init(baseURL, isDebug)` called from `:app` Application class.
3. DI loading order matters: `kotlinModule` → `dataRemoteModule` → `dataModule` → `domainModule` → `presentationModule`

## DI Module Structure

- **kotlinModule:** `Dispatchers.IO`
- **dataRemoteModule:** `OkHttpClient`, `HttpLoggingInterceptor`, `ApiServiceFactory`
- **dataModule:** Remote data source implementations
- **domainModule:** Repository implementations, use cases
- **presentationModule:** ViewModels

## Rules for Adding a New Module

1. Register repository as `single<YourRepository> { YourRepositoryImpl(get()) }`
2. Register use case as `factory { YourUseCase(repository = get(), dispatcher = Dispatchers.IO) }`
3. Register ViewModel as `viewModel { YourViewModel(yourUseCase = get(), resourceProvider = get()) }`
4. Add new Koin module to `loadFeature` list in `TakeHomeModule`
5. Verify — `CheckTakeHomeModules` should still pass

## DI Wiring Example

```kotlin
// com.ctb.main/TakeHomeModule.kt

// In the loadFeature list:
private val dataModule =
    module {
        factory<YourRemoteDataSource> {
            YourRemoteDataSourceImpl(api = get())
        }
    }

private val domainModule =
    module {
        single<YourRepository> {
            YourRepositoryImpl(remoteDataSource = get())
        }
        factory {
            YourUseCase(
                repository = get(),
                dispatcher = Dispatchers.IO,
            )
        }
    }

private val presentationModule =
    module {
        viewModel {
            YourViewModel(
                yourUseCase = get(),
                resourceProvider = get(),
            )
        }
    }
```

## Koin Graph Verification Test

```kotlin
// main/src/test/
class CheckTakeHomeModules : KoinTest {
    private val mockModule = module {
        single { HttpLoggingInterceptor() }
        single { OkHttpClientFactory.makeOkHttpClient(get()) }
    }

    @Before
    fun setup() {
        TakeHomeModule.baseURL = "https://mockurl.takehome.com.br"
        startKoin {
            androidContext(mockk<Context>())
            modules(mockModule, *loadFeature.toTypedArray())
        }
    }

    @After
    fun tearDown() = stopKoin()

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun `should verify koin graph injection`() {
        val modules = module { includes(mockModule, *loadFeature.toTypedArray()) }
        modules.verify()
    }
}
```