package com.aiinty.kanamemo.core.kana
import com.aiinty.kanamemo.core.kana.Constants.*

class Kana {

    companion object {

        public fun GenerateRandomText(len: Int, kana:KanaType): ArrayList<Mora> {
            val result = ArrayList<Mora>()

            for (i in 0..len) {
                val symbol = when (kana) {
                    KanaType.KATAKANA -> Constants.BASIC_KATAKANA.entries.elementAt((0..<Constants.BASIC_KATAKANA.size).random())
                    KanaType.HIRAGANA -> Constants.BASIC_HIRAGANA.entries.elementAt((0..<Constants.BASIC_HIRAGANA.size).random())
                }
                result.add(Mora(symbol.key, symbol.value))
            }
            return result
        }
    }
}