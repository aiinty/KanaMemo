package com.aiinty.kanamemo.core.question

import com.aiinty.kanamemo.core.kana.Mora

class TextQuestion(val text: ArrayList<Mora> = arrayListOf()) : Question() {
    init {
        text.forEach { entry -> question += entry.char }
        text.forEach { entry -> answer += entry.reading + " " }
    }
}