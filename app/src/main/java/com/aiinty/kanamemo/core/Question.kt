package com.aiinty.kanamemo.core

import com.aiinty.kanamemo.core.kana.Mora

class Question(
    val text: ArrayList<Mora> = arrayListOf()
) {

    var question = ""
    var answer = ""

    init {
        text.forEach { entry -> question += entry.char }
        text.forEach { entry -> answer += entry.reading + " " }
    }
}