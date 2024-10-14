package com.aiinty.kanamemo.ui.learn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aiinty.kanamemo.core.kana.Constants
import com.aiinty.kanamemo.core.kana.Kana
import com.aiinty.kanamemo.core.kana.Mora
import com.aiinty.kanamemo.ui.viewmodel.KanaMemoViewModel

@Preview
@Composable
fun LearnScreen(
    modifier: Modifier = Modifier,
    viewModel: KanaMemoViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isHiragana = remember { mutableStateOf(true) }
        viewModel.createLearnScreen(LocalContext.current)

        Row (Modifier.selectableGroup())
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = isHiragana.value,
                    onClick = { isHiragana.value = true }
                )
                Text(
                    text = "Hiragana",
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = !isHiragana.value,
                    onClick = { isHiragana.value = false }
                )
                Text(
                    text = "Katakana",
                )
            }
        }

        // FIXME: performance issue LOL
        AnimatedVisibility(isHiragana.value) {
            CreateMoraList(Constants.KanaType.HIRAGANA, 5)
        }

        AnimatedVisibility(!isHiragana.value) {
            CreateMoraList(Constants.KanaType.KATAKANA, 5)
        }

    }
}

@Composable
private fun CreateMoraList(kana: Constants.KanaType, itemsPerRow: Int) {
    var iterator: Iterator<Map.Entry<String, String>>? = null
    var size = 0
     when(kana) {
        Constants.KanaType.HIRAGANA -> {
            iterator = Constants.BASIC_HIRAGANA.iterator()
            size = Constants.BASIC_HIRAGANA.size / itemsPerRow
        }
        Constants.KanaType.KATAKANA -> {
            iterator = Constants.BASIC_KATAKANA.iterator()
            size = Constants.BASIC_KATAKANA.size / itemsPerRow
        }
    }
    LazyColumn (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(size) {
            while (iterator.hasNext()){
                Row(Modifier.fillMaxWidth()) {
                    for (i in 0..<itemsPerRow) {
                        if (iterator.hasNext()) {
                            MoraItem(Modifier.weight(1f), Kana.moraFromMapEntry(iterator.next()))
                        }
                    }
                }

            }
        }
    }
}

@Composable
private fun MoraItem(
    modifier: Modifier,
    mora: Mora,
    viewModel: KanaMemoViewModel = viewModel()
) {
    // TODO: add tts
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { viewModel.moraToSpeech(mora.char) }
    ) {
        Text(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            text = mora.char
        )
        Text(
            fontSize = 16.sp,
            text = mora.reading
        )
    }
}