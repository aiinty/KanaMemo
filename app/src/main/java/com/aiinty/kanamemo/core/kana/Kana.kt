package com.aiinty.kanamemo.core.kana

import com.aiinty.kanamemo.core.kana.Constants.*

class Kana {

    companion object {

        fun randomMora(kana: KanaType) : Mora {
            val symbol = when (kana) {
                KanaType.HIRAGANA -> Constants.BASIC_KATAKANA.entries.elementAt((0..<Constants.BASIC_KATAKANA.size).random())
                KanaType.KATAKANA -> Constants.BASIC_HIRAGANA.entries.elementAt((0..<Constants.BASIC_HIRAGANA.size).random())
            }
            return Mora (symbol.key, symbol.value)
        }

        fun generateRandomText(len: Int, kana:KanaType): ArrayList<Mora> {
            val result = ArrayList<Mora>()
            for (i in 0..<len) {
                result.add(randomMora(kana))
            }
            return result
        }
    }
}