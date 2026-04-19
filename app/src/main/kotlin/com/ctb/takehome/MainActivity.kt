package com.ctb.takehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ctb.design.navigation.TakeHomeNavHost
import com.ctb.design.theme.AppTheme
import com.ctb.presentation.sample.SampleRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    TakeHomeNavHost(
                        navController = navController,
                        startRoute = SampleRoute::class.qualifiedName ?: "sample"
                    )
                }
            }
        }
    }
}
