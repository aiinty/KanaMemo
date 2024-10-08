package com.aiinty.kanamemo.core.kana

/**
 * The minimum syllabic unit of the alphabet.
 * @property char one or more syllable chars (e.g. きゅ or は).
 * @property reading syllable reading on the Hepburn system.
 */
data class Mora(val char: String, val reading: String)