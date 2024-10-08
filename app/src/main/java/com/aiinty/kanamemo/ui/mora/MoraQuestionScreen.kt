package com.aiinty.kanamemo.ui.mora

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aiinty.kanamemo.ui.viewmodel.QuestionScreenViewModel

@Composable
fun MoraQuestionScreen(
    modifier: Modifier = Modifier,
    viewModel: QuestionScreenViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp, 32.dp),
    ) {

    }
}