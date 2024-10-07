package com.aiinty.kanamemo.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiinty.kanamemo.core.Question
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana

@Composable
fun QuestionScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(16.dp),
    ) {
        val isHiragana = remember { mutableStateOf(true) }
        val textLength = remember { mutableStateOf("") }
        val currentQuestion = remember { mutableStateOf(Question()) }

        OutlinedTextField(
            value = textLength.value,
            onValueChange = { textLength.value = it },
            label = { Text("Enter length") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

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
                currentQuestion.value = createQuestion(textLength.value.toInt(), when(isHiragana.value) {
                    true -> Constants.KanaType.HIRAGANA
                    false -> Constants.KanaType.KATAKANA
                })
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
            text = currentQuestion.value.question,
            fontSize = 24.sp
        )
    }
}

private fun createQuestion(length: Int, kana: Constants.KanaType) : Question {
    return Question(Kana.GenerateRandomText(length, kana))
}