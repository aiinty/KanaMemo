package com.aiinty.kanamemo.ui.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aiinty.kanamemo.core.TTSService
import com.aiinty.kanamemo.core.question.TextQuestion
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana
import com.aiinty.kanamemo.core.question.Question
import com.aiinty.kanamemo.core.question.KanaQuestion
import com.aiinty.kanamemo.core.question.RomajiQuestion

class QuestionScreenViewModel : ViewModel() {

    var currentQuestion by mutableStateOf<Question>(TextQuestion())
    var currentKana by mutableStateOf(Constants.KanaType.HIRAGANA)
    var isKanaQuestion by mutableStateOf(true)
    private var ttsService: TTSService? = null

    fun createTextQuestion(length: Int) {
        currentQuestion = TextQuestion(Kana.randomText(length, currentKana))
    }

    fun createMoraQuestion(context: Context) {
        ttsService = TTSService(context)
        currentQuestion = when (isKanaQuestion) {
            true -> KanaQuestion(Kana.randomMora(currentKana))
            false -> RomajiQuestion(Kana.randomMora(currentKana))
        }
    }

    fun readingToSpeech(reading: String) {
        ttsService?.speak(Kana.moraFromString(reading, currentKana).char)
    }

    fun moraToSpeech(mora: String) {
        ttsService?.speak(mora)
    }
}