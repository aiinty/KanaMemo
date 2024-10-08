package com.aiinty.kanamemo.ui.text

import androidx.compose.animation.AnimatedVisibility
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.ui.viewmodel.QuestionScreenViewModel

@Composable
fun TextQuestion(
    modifier: Modifier = Modifier,
    viewModel: QuestionScreenViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(16.dp, 32.dp),
    ) {
        val isHiragana = remember { mutableStateOf(true) }
        val textLength = remember { mutableStateOf("") }
        val showAnswer = remember { mutableStateOf(false) }

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
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = !isHiragana.value,
                    onClick = { isHiragana.value = false }
                )
                Text(
                    text = "Katakana",
                )
            }
        }

        Button(
            onClick = {
                val length = textLength.value.toIntOrNull()
                if (length != null && length > 0) {
                    showAnswer.value = false
                    viewModel.createQuestion(textLength.value.toInt(), when(isHiragana.value) {
                        true -> Constants.KanaType.HIRAGANA
                        false -> Constants.KanaType.KATAKANA
                    })
                }
            }) {
            Text(
                text = "Generate text",
            )
        }

        Text(
            text = "Kana text:",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = viewModel.question.question,
            fontSize = 24.sp
        )

        Button(
            onClick = {
                if (viewModel.question.text.isNotEmpty()) {
                    showAnswer.value = !showAnswer.value
                }
            }
        ) {
            AnimatedVisibility(showAnswer.value) {
                Text("Hide answer")
            }
            AnimatedVisibility(!showAnswer.value) {
                Text("Show answer")
            }
        }

        Text(
            text = "Answer text:",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )

        AnimatedVisibility(showAnswer.value) {
            Text(
                text = viewModel.question.answer,
                fontSize = 24.sp
            )
        }
    }
}