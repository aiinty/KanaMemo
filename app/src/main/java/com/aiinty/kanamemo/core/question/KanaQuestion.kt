package com.aiinty.kanamemo.core.question

import com.aiinty.kanamemo.core.kana.Mora

class KanaQuestion(val mora: Mora) : Question() {
    init {
        question += mora.char
        answer += mora.reading
    }
}