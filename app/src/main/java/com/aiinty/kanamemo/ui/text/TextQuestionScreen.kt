package com.aiinty.kanamemo.ui.text

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.question.TextQuestion
import com.aiinty.kanamemo.ui.viewmodel.KanaMemoViewModel

@Preview
@Composable
fun TextQuestionScreen(
    modifier: Modifier = Modifier,
    viewModel: KanaMemoViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(16.dp),
    ) {
        val isHiragana = remember { mutableStateOf(true) }
        val textLength = remember { mutableStateOf("") }
        val showAnswer = remember { mutableStateOf(false) }

        Column (
            modifier = Modifier.fillMaxSize().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kana text:",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = viewModel.currentQuestion.question,
                fontSize = 24.sp,
                modifier = Modifier.verticalScroll(rememberScrollState()).weight(1f)
            )
        }

        Column (
            modifier = Modifier.fillMaxSize().padding(top = 16.dp).weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Romaji text:",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )

            AnimatedVisibility(
                showAnswer.value,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = viewModel.currentQuestion.answer,
                    fontSize = 24.sp,
                    modifier = Modifier.verticalScroll(rememberScrollState())
                )
            }
        }

        Button(
            onClick = {
                if (viewModel.currentQuestion is TextQuestion
                    && (viewModel.currentQuestion as TextQuestion).text.isNotEmpty()) {
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

        OutlinedTextField(
            value = textLength.value,
            onValueChange = { textLength.value = it },
            label = { Text("Enter length") },
            modifier = Modifier.padding(top = 32.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row (Modifier.selectableGroup())
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
                    when(isHiragana.value) {
                        true -> viewModel.currentKana = Constants.KanaType.HIRAGANA
                        false -> viewModel.currentKana = Constants.KanaType.KATAKANA
                    }
                    viewModel.createTextQuestion(textLength.value.toInt())
                }
            }) {
            Text(
                text = "Random text",
            )
        }
    }
}