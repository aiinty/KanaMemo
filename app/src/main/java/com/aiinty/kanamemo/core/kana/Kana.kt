package com.aiinty.kanamemo.core.kana

import com.aiinty.kanamemo.core.kana.Constants.*

/**
 * A class for working with hiragana and katakana.
 */
class Kana {

    companion object {

        /**
         * Creates mora from string by reading.
         * @return mora that have [str] reading in [kana].
         */
        fun moraFromString(str: String, kana: KanaType) : Mora {
            val char = when (kana) {
                KanaType.HIRAGANA -> Constants.BASIC_HIRAGANA.filterValues { it == str }.keys
                KanaType.KATAKANA -> Constants.BASIC_HIRAGANA.filterValues { it == str }.keys
            }
            // FIXME: e.g. ぢ and じ, ず and づ have the same readings in Hepburn
//            if (char.size > 1) {
//                throw Exception("'${str}' has more than one char in ${kana.name}")
//            }
            if (char.isEmpty()) {
                throw Exception("'${str}' doesn't have char in ${kana.name}")
            }
            return Mora (char.first(), str)
        }

        /**
         * Creates one random mora from [kana].
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