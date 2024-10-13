package com.aiinty.kanamemo.ui.mora

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana
import com.aiinty.kanamemo.ui.viewmodel.QuestionScreenViewModel

@Preview
@Composable
fun MoraQuestionScreen(
    modifier: Modifier = Modifier,
    viewModel: QuestionScreenViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        val isHiragana = remember { mutableStateOf(true) }
        val isKanaQuestion = remember { mutableStateOf(true) }
        val answers = remember { mutableStateOf(arrayListOf("")) }
        val context = LocalContext.current

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().weight(1f)
        ) {
            Text(
                text = viewModel.currentQuestion.question,
                fontSize = 128.sp,
            )
        }


        Row (verticalAlignment = Alignment.CenterVertically) {

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

            Column(Modifier.selectableGroup())
            {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = isKanaQuestion.value,
                        onClick = { isKanaQuestion.value = true }
                    )
                    Text(
                        text = "Kana",
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = !isKanaQuestion.value,
                        onClick = { isKanaQuestion.value = false }
                    )
                    Text(
                        text = "Romaji",
                    )
                }
            }

        }

        Button(
            onClick = {
                when(isHiragana.value) {
                    true -> viewModel.currentKana = Constants.KanaType.HIRAGANA
                    false -> viewModel.currentKana = Constants.KanaType.KATAKANA
                }
                viewModel.isKanaQuestion = isKanaQuestion.value
                val kana = viewModel.currentKana

                viewModel.createMoraQuestion(context)
                answers.value = arrayListOf(viewModel.currentQuestion.answer)
                while (answers.value.size != 3) {
                    val mora = Kana.randomMora(kana)
                    if (mora.reading == viewModel.currentQuestion.answer ||
                        mora.reading == viewModel.currentQuestion.question) {
                        continue
                    }
                    if (viewModel.isKanaQuestion) {
                        answers.value.add(mora.reading)
                    }
                    else {
                        answers.value.add(mora.char)
                    }
                }
                answers.value.shuffle()
            }) {
            Text(
                text = "Random Mora",
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            if (answers.value.size == 3) {
                answers.value.forEach { answer ->
                    Button (
                        onClick = {
                            if (viewModel.isKanaQuestion) {
                                viewModel.readingToSpeech(answer)
                            } else {
                                viewModel.moraToSpeech(answer)
                            }
                            if (viewModel.currentQuestion.answer == answer) {
                                Toast.makeText(context, "Correct ^.^", Toast.LENGTH_SHORT).show()
                            }
                            else {
                                Toast.makeText(context, "Wrong :(", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(answer)
                    }
                }
            }
        }

    }
}