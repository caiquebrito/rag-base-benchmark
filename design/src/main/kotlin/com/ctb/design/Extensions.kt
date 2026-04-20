package com.ctb.design

import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import com.ctb.design.theme.TakeHomeTheme

fun ComposeView.setComposableContent(content: @Composable () -> Unit) {
    this.apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            TakeHomeTheme {
                content()
            }
        }
    }
}

val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt().dp
