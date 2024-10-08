package com.aiinty.kanamemo.core.question

import com.aiinty.kanamemo.core.kana.Mora

/**
 * A base class for kana Questions.
 * @property mora the [Mora] on which the question is based.
 * @property question the [Mora.char] of [mora]
 * @property answer the [Mora.reading] of [mora]
 */
class KanaQuestion(val mora: Mora) : Question() {
    init {
        question += mora.char
        answer += mora.reading
    }
}