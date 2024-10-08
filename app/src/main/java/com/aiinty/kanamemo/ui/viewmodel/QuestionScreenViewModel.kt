package com.aiinty.kanamemo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aiinty.kanamemo.core.question.TextQuestion
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana
import com.aiinty.kanamemo.core.question.Question
import com.aiinty.kanamemo.core.question.KanaQuestion
import com.aiinty.kanamemo.core.question.RomajiQuestion

class QuestionScreenViewModel : ViewModel() {

    var currentQuestion by mutableStateOf<Question>(TextQuestion())

    fun createTextQuestion(length: Int, kana: Constants.KanaType) {
        currentQuestion = TextQuestion(Kana.randomText(length, kana))
    }

    fun createMoraQuestion(isKanaQuestion: Boolean, kana: Constants.KanaType) {
        currentQuestion = when (isKanaQuestion) {
            true -> KanaQuestion(Kana.randomMora(kana))
            false -> RomajiQuestion(Kana.randomMora(kana))
        }
    }
}