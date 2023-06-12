package com.shankarlohar.flashnews.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.shankarlohar.flashnews.states.BaseState
import com.shankarlohar.flashnews.ui.theme.FlashNewsTheme
import com.shankarlohar.flashnews.viewmodels.BaseVM

abstract class BaseActivity<VM : BaseVM<State>, State : BaseState> : ComponentActivity() {
    abstract val viewModel: VM

    @Composable
    abstract fun Content()

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            handleSystemBarAndNavigationColor(isSystemInDarkTheme())
            
            FlashNewsTheme() {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Content()
                }
            }
        }
    }

    private fun handleSystemBarAndNavigationColor(isDarkTheme: Boolean) {
        val color = if (isDarkTheme) {
            Color(0xFF121212).toArgb()
        } else {
            Color.White.toArgb()
        }

        window?.statusBarColor = color
        window?.navigationBarColor = color

        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightNavigationBars = !isDarkTheme
            isAppearanceLightStatusBars = !isDarkTheme
        }
    }
}