package com.ctb.design.token

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Spacing system based on an 8dp grid.
 * Base: 32dp (medium) — increments/decrements of 8dp.
 *
 * Smaller than base: xSmall (24), xxSmall (16), xxxSmall (8)
 * Larger than base: xLarge (40), xxLarge (48), xxxLarge (56)
 */
object Spacing {

    /** 8dp — xxxSmall */
    val xxxSmall: Dp = 8.dp

    /** 16dp — xxSmall */
    val xxSmall: Dp = 16.dp

    /** 24dp — xSmall */
    val xSmall: Dp = 24.dp

    /** 32dp — medium (base) */
    val medium: Dp = 32.dp

    /** 40dp — xLarge */
    val xLarge: Dp = 40.dp

    /** 48dp — xxLarge */
    val xxLarge: Dp = 48.dp

    /** 56dp — xxxLarge */
    val xxxLarge: Dp = 56.dp
}
