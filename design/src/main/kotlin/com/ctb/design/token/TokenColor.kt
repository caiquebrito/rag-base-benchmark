package com.ctb.design.token

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Raw color tokens from the design system.
 * These are the source-of-truth hex values — used directly in light theme,
 * and mapped to dark-theme equivalents inside TouristPathTheme.
 *
 * Access via CompositionLocal:
 *   val colors = LocalAppColors.current
 *   colors.primary.main
 *   colors.accent.light
 */
object TokenColor {

    /** Azul Petróleo — Brand & high-priority actions */
    val Primary = TokenColorGroup(
        main = Color(0xFF17B0CF),
        light = Color(0xFFB2E7F1),
        dark = Color(0xFF0A4855)
    )

    /** Verde Suave — Exploration & sustainability */
    val Secondary = TokenColorGroup(
        main = Color(0xFF7FB685),
        light = Color(0xFFD1E6D3),
        dark = Color(0xFF355239)
    )

    /** Laranja Memória — Highlights & notifications */
    val Accent = TokenColorGroup(
        main = Color(0xFFF4A261),
        light = Color(0xFFFCDBBD),
        dark = Color(0xFF6D3E18)
    )

    /** Text colors */
    val Text = TokenColorGroup(
        main = Color(0xFF0C0C0C),
        light = Color(0xFF6C6C6C),
        dark = Color(0xFF0C0C0C)
    )

    /** Surface / background colors */
    val Surface = TokenColorGroup(
        main = Color(0xFFFFFFFF),
        light = Color(0xFFFAFAFA),
        dark = Color(0xFFF1F1F1)
    )

    /** Semantic status colors */
    val Status = StatusTokens(
        error = Color(0xFFE74C3C),
        success = Color(0xFF2ECC71),
        warning = Color(0xFFF39C12),
        info = Color(0xFF3498DB)
    )
}

@Immutable
data class TokenColorGroup(
    val main: Color,
    val light: Color,
    val dark: Color
)

@Immutable
data class StatusTokens(
    val error: Color,
    val success: Color,
    val warning: Color,
    val info: Color
)
