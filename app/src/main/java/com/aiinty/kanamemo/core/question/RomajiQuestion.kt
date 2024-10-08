package com.aiinty.kanamemo.core.question

import com.aiinty.kanamemo.core.kana.Mora

/**
 * A base class for romaji (romanization) Questions.
 * @property mora the [Mora] on which the question is based.
 * @property question the [Mora.reading] of [mora]
 * @property answer the [Mora.char] of [mora]
 */
class RomajiQuestion(val mora: Mora) : Question() {
    init {
        question += mora.reading
        answer += mora.char
    }
}