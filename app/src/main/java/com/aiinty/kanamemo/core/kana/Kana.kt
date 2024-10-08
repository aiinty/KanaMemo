package com.aiinty.kanamemo.core.kana

import com.aiinty.kanamemo.core.kana.Constants.*

/**
 * A class for working with hiragana and katakana.
 */
class Kana {

    companion object {

        /**
         * Gets one random mora from [kana].
         * @return random mora of a certain [kana].
         */
        fun randomMora(kana: KanaType) : Mora {
            val symbol = when (kana) {
                KanaType.HIRAGANA -> Constants.BASIC_HIRAGANA.entries.elementAt((0..<Constants.BASIC_HIRAGANA.size).random())
                KanaType.KATAKANA -> Constants.BASIC_KATAKANA.entries.elementAt((0..<Constants.BASIC_KATAKANA.size).random())
            }
            return Mora (symbol.key, symbol.value)
        }

        /**
         * Creates a text of length [len] from random moras from a specific [kana].
         * @return an [ArrayList] of [Mora] with length [len].
         */
        fun randomText(len: Int, kana:KanaType): ArrayList<Mora> {
            val result = ArrayList<Mora>()
            for (i in 0..<len) {
                result.add(randomMora(kana))
            }
            return result
        }
    }
}