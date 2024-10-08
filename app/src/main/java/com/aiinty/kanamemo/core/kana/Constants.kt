package com.aiinty.kanamemo.core.kana

/**
 *  A class containing the necessary constants.
 */
class Constants {

    /**
     * An enum defining alphabet types.
     */
    enum class KanaType {
        HIRAGANA,
        KATAKANA
    }

    companion object {
        /**
         * An Hepburn romanization of some UNICODE chars of hiragana (0x3041 - 0x309f).
         */
        val BASIC_HIRAGANA = mapOf(
            "あ" to "a", "い" to "i", "う" to "u", "え" to "e", "お" to "o",
            "か" to "ka", "き" to "ki", "く" to "ku", "け" to "ke", "こ" to "ko",
            "が" to "ga", "ぎ" to "gi", "ぐ" to "gu", "げ" to "ge", "ご" to "go",
            "さ" to "sa", "し" to "shi", "す" to "su", "せ" to "se", "そ" to "so",
            "ざ" to "za", "じ" to "ji", "ず" to "zu", "ぜ" to "ze", "ぞ" to "zo",
            "た" to "ta", "ち" to "chi", "つ" to "tsu", "て" to "te", "と" to "to",
            "だ" to "da", "ぢ" to "ji", "づ" to "zu", "で" to "de", "ど" to "do",
            "な" to "na", "に" to "ni", "ぬ" to "nu", "ね" to "ne", "の" to "no",
            "は" to "ha", "ひ" to "hi", "ふ" to "fu", "へ" to "he", "ほ" to "ho",
            "ば" to "ba", "び" to "bi", "ぶ" to "bu", "べ" to "be", "ぼ" to "bo",
            "ぱ" to "pa", "ぴ" to "pi", "ぷ" to "pu", "ぺ" to "pe", "ぽ" to "po",
            "ま" to "ma", "み" to "mi", "む" to "me", "め" to "me", "も" to "mo",
            "や" to "ya", "ゆ" to "yu", "よ" to "yo",
            "ら" to "ra", "り" to "ri", "る" to "ru", "れ" to "re", "ろ" to "ro",
            "わ" to "wa", "を" to "wo", "ん" to "n",
       )
        /**
         * An Hepburn romanization of some UNICODE chars of katakana 0x30a0 - 0x30ff).
         */
        val BASIC_KATAKANA = mapOf(
            "ア" to "a", "イ" to "i", "ウ" to "u", "エ" to "e", "オ" to "o",
            "カ" to "ka", "キ" to "ki", "ク" to "ku", "ケ" to "ke", "コ" to "ko",
            "ガ" to "ga", "ギ" to "gi", "グ" to "gu", "ゲ" to "ge", "ゴ" to "go",
            "サ" to "sa", "シ" to "shi", "ス" to "su", "セ" to "se", "ソ" to "so",
            "ザ" to "za", "ジ" to "ji", "ズ" to "zu", "ゼ" to "ze", "ゾ" to "zo",
            "タ" to "ta", "チ" to "chi", "ツ" to "tsu", "テ" to "te", "ト" to "to",
            "ダ" to "da", "ヂ" to "ji", "ヅ" to "zu", "デ" to "de", "ド" to "do",
            "ナ" to "na", "ニ" to "ni", "ヌ" to "nu", "ネ" to "ne", "ノ" to "no",
            "ハ" to "ha", "ヒ" to "hi", "フ" to "fu", "ヘ" to "he", "ホ" to "ho",
            "バ" to "ba", "ビ" to "bi", "ブ" to "bu", "ベ" to "be", "ボ" to "bo",
            "パ" to "pa", "ピ" to "pi", "プ" to "pu", "ペ" to "pe", "ポ" to "po",
            "マ" to "ma", "ミ" to "mi", "ム" to "mu", "メ" to "me", "モ" to "mo",
            "ヤ" to "ya", "ユ" to "yu", "ヨ" to "yo",
            "ラ" to "ra", "リ" to "ri", "ル" to "ru", "レ" to "re", "ロ" to "ro",
            "ワ" to "wa", "ヲ" to "wo", "ン" to "n",
        )
    }
}