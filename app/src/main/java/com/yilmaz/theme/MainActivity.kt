package com.yilmaz.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.yilmaz.theme.ui.theme.ThemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val theme = DataStoreUtils(applicationContext).getTheme()
                .collectAsState(initial = DataStoreUtils.themes[0])

            ThemeTheme(
                darkTheme = when (theme.value) {
                    DataStoreUtils.themes[0] -> isSystemInDarkTheme()
                    DataStoreUtils.themes[1] -> true
                    else -> false
                }
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetUpNavigationGraph(navHostController = rememberNavController())
                }
            }
        }
    }
}