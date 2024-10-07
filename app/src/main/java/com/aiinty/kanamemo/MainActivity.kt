package com.aiinty.kanamemo

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aiinty.kanamemo.ui.theme.KanaMemoTheme
import com.aiinty.kanamemo.ui.main.QuestionScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContent {
            KanaMemoApp()
        }
    }
}

@Composable
fun KanaMemoApp() {
    KanaMemoTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        ) {
            QuestionScreen()
        }
    }
}