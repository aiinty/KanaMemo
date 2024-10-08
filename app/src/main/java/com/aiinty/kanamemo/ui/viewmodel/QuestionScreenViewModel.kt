package com.aiinty.kanamemo.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aiinty.kanamemo.core.question.TextQuestion
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana
import com.aiinty.kanamemo.core.question.Question
import com.aiinty.kanamemo.core.question.MoraQuestion

class QuestionScreenViewModel : ViewModel() {

    var question by mutableStateOf<Question>(TextQuestion())

    fun createTextQuestion(length: Int, kana: Constants.KanaType) {
        question = TextQuestion(Kana.randomText(length, kana))
    }

    fun createMoraQuestion(kana: Constants.KanaType) {
        question = MoraQuestion(Kana.randomMora(kana))
    }
}