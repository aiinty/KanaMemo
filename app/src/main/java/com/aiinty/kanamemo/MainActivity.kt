package com.aiinty.kanamemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiinty.kanamemo.ui.theme.KanaMemoTheme
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana
import com.aiinty.kanamemo.core.Question

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KanaMemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

private fun createQuestion(length: Int, kana: Constants.KanaType) : Question {
    return Question(Kana.GenerateRandomText(length, kana))
}

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(16.dp),
    ) {
        val isHiragana = remember { mutableStateOf(true) }
        val currentText = remember { mutableStateOf("") }

        Column(Modifier.selectableGroup())
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = isHiragana.value,
                    onClick = { isHiragana.value = true }
                )
                Text(
                    text = "Hiragana",
                    fontSize = 24.sp
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = !isHiragana.value,
                    onClick = { isHiragana.value = false }
                )
                Text(
                    text = "Katakana",
                    fontSize = 24.sp
                )
            }
        }

        Button(
            onClick = {
                currentText.value = createQuestion(50, when(isHiragana.value) {
                    true -> Constants.KanaType.HIRAGANA
                    false -> Constants.KanaType.KATAKANA
                }).question
            }) {
            Text(
                text = "Generate text",
            )
        }

        Text(
            text = "Kana text:",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = currentText.value,
            fontSize = 24.sp
        )
    }
}