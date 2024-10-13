package com.aiinty.kanamemo.core

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class TTSService(private val context: Context) {

    private var textToSpeech: TextToSpeech? = null

    //The speech synthesizer takes a moment to initialize on most devices.
    //A simple way to get around this is to immediately call speak() in the init method.
    //This will force the synthesizer to "warm up" .
    init {
        speak("")
    }

    fun speak(text: String) {
        textToSpeech = TextToSpeech(context) {
            if (it == TextToSpeech.SUCCESS) {
                textToSpeech?.let { tts ->
                    tts.language = Locale.JAPAN
                    tts.setSpeechRate(1f)
                    tts.speak(
                        text,
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        null
                    )
                }
            }
        }
    }
}