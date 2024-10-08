package com.aiinty.kanamemo.core.question

import com.aiinty.kanamemo.core.kana.Mora

/**
 * A base class for random text Questions.
 * @property text the [ArrayList] of [Mora] on which the question is based.
 * @property question the every [Mora.char] of [mora] in [text]
 * @property answer the every [Mora.reading] of [mora] in [text], separated by space
 */
class TextQuestion(val text: ArrayList<Mora> = arrayListOf()) : Question() {
    init {
        text.forEach { entry -> question += entry.char }
        text.forEach { entry -> answer += entry.reading + " " }
    }
}