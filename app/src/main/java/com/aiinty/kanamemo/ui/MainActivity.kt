package com.aiinty.kanamemo.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aiinty.kanamemo.ui.mora.MoraQuestionScreen
import com.aiinty.kanamemo.ui.theme.KanaMemoTheme
import com.aiinty.kanamemo.ui.text.TextQuestionScreen
import com.aiinty.kanamemo.ui.navigation.Destination
import com.aiinty.kanamemo.ui.navigation.NavigationBottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContent {
            KanaMemoApp(
                startDestination = Destination.TEXT
            )
        }
    }
}

@Composable
fun KanaMemoApp(
    startDestination: String = Destination.TEXT
) {
    val navController = rememberNavController()
    KanaMemoTheme {
        Surface  (
            modifier = Modifier.fillMaxSize()
        ) {
            Box {
                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                ) {
                    composable(Destination.TEXT) {
                        TextQuestionScreen()
                    }
                    composable(Destination.MORA){
                        MoraQuestionScreen()
                    }
                }
                NavigationBottomBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    navController = navController
                )
            }
        }
    }
}