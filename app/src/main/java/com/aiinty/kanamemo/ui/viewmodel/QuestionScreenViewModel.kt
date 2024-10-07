package com.aiinty.kanamemo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aiinty.kanamemo.core.Question
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana

class QuestionScreenViewModel : ViewModel() {

    var question by mutableStateOf(Question())

    fun createQuestion(length: Int, kana: Constants.KanaType) {
        question = Question(Kana.GenerateRandomText(length, kana))
    }
}