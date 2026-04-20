package com.ctb.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.ctb.design.token.StatusTokens
import com.ctb.design.token.TokenColor
import com.ctb.design.token.TokenColorGroup

/**
 * Full app theme — wrap this once at the root of your composition.
 */
@Composable
fun RagTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val tokenColors = if (darkTheme) darkTokenColors() else lightTokenColors()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography
    ) {
        androidx.compose.runtime.CompositionLocalProvider(
            LocalTokenColors provides tokenColors
        ) {
            content()
        }
    }
}

// ── Material3 color scheme mapped from tokens ──

private val LightColorScheme = lightColorScheme(
    primary = TokenColor.Primary.main,
    onPrimary = Color.White,
    primaryContainer = TokenColor.Primary.light,
    onPrimaryContainer = TokenColor.Primary.dark,
    secondary = TokenColor.Secondary.main,
    onSecondary = Color.White,
    secondaryContainer = TokenColor.Secondary.light,
    onSecondaryContainer = TokenColor.Secondary.dark,
    tertiary = TokenColor.Accent.main,
    onTertiary = Color.White,
    tertiaryContainer = TokenColor.Accent.light,
    onTertiaryContainer = TokenColor.Accent.dark,
    background = TokenColor.Surface.light,
    onBackground = TokenColor.Text.dark,
    surface = TokenColor.Surface.main,
    onSurface = TokenColor.Text.dark,
    surfaceVariant = TokenColor.Surface.dark,
    error = TokenColor.Status.error,
    onError = Color.White,
)

private val DarkColorScheme = darkColorScheme(
    primary = TokenColor.Primary.main,
    onPrimary = Color.White,
    primaryContainer = TokenColor.Primary.dark,
    onPrimaryContainer = TokenColor.Primary.light,
    secondary = TokenColor.Secondary.main,
    onSecondary = Color.White,
    secondaryContainer = TokenColor.Secondary.dark,
    onSecondaryContainer = TokenColor.Secondary.light,
    tertiary = TokenColor.Accent.main,
    onTertiary = Color.White,
    tertiaryContainer = TokenColor.Accent.dark,
    onTertiaryContainer = TokenColor.Accent.light,
    background = Color(0xFF121212),
    onBackground = Color(0xFFFAFAFA),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0),
    surfaceVariant = Color(0xFF2C2C2C),
    error = TokenColor.Status.error,
    onError = Color.White,
)

// ── Token color access in composition ──

@Immutable
data class TouristPathColors(
    val primary: TokenColorGroup,
    val secondary: TokenColorGroup,
    val accent: TokenColorGroup,
    val text: TokenColorGroup,
    val surface: TokenColorGroup,
    val status: StatusTokens
)

val LocalTokenColors = staticCompositionLocalOf { TouristPathColors(
    primary = TokenColor.Primary,
    secondary = TokenColor.Secondary,
    accent = TokenColor.Accent,
    text = TokenColor.Text,
    surface = TokenColor.Surface,
    status = TokenColor.Status
) }

fun darkTokenColors() = TouristPathColors(
    primary = TokenColorGroup(
        main = TokenColor.Primary.main,
        light = TokenColor.Primary.dark,
        dark = TokenColor.Primary.light
    ),
    secondary = TokenColorGroup(
        main = TokenColor.Secondary.main,
        light = TokenColor.Secondary.dark,
        dark = TokenColor.Secondary.light
    ),
    accent = TokenColorGroup(
        main = TokenColor.Accent.main,
        light = TokenColor.Accent.dark,
        dark = TokenColor.Accent.light
    ),
    text = TokenColorGroup(
        main = Color(0xFFFAFAFA),
        light = Color(0xFFB0B0B0),
        dark = Color(0xFFFFFFFF)
    ),
    surface = TokenColorGroup(
        main = Color(0xFF1E1E1E),
        light = Color(0xFF2C2C2C),
        dark = Color(0xFF121212)
    ),
    status = TokenColor.Status
)

fun lightTokenColors() = TouristPathColors(
    primary = TokenColor.Primary,
    secondary = TokenColor.Secondary,
    accent = TokenColor.Accent,
    text = TokenColor.Text,
    surface = TokenColor.Surface,
    status = TokenColor.Status
)

// ── Convenience: MaterialTheme extension for tokens ──

val MaterialTheme.tokenColors: TouristPathColors
    @Composable
    get() = LocalTokenColors.current

// ── Convenience alias for backwards compatibility ──

@Composable
fun TakeHomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    RagTheme(darkTheme = darkTheme, content = content)
}
