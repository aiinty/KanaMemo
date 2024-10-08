package com.aiinty.kanamemo.core.question

import com.aiinty.kanamemo.core.kana.Mora

class RomajiQuestion(val mora: Mora) : Question() {
    init {
        question += mora.reading
        answer += mora.char
    }
}