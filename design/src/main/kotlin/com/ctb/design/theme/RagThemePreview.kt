package com.ctb.design.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RagThemePreview(
    color: Color = Color.White,
    content: @Composable BoxScope.() -> Unit,
) {
    RagTheme {
        Box(modifier = Modifier.background(color)) {
            content(this)
        }
    }
}