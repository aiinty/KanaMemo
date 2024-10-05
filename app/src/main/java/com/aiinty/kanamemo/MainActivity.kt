package com.aiinty.kanamemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiinty.kanamemo.ui.theme.KanaMemoTheme
import com.aiinty.kanamemo.utils.Constants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KanaMemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(
                        input = generateRandomText(60),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

private fun generateRandomText(length:Int) : String {
    var result = ""

    for (i in 0..length) {
        result += Constants.BASIC_HIRAGANA.random()
    }

    return result
}

@Composable
fun MainView(input: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp),
    ) {
        Text(
            text = "Hiragana text:",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = input,
            fontSize = 24.sp
        )
    }
}