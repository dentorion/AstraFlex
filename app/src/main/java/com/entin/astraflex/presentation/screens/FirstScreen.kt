package com.entin.astraflex.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun FirstScreen(
    viewModel: FirstScreenViewModel,
) {
    Column {
        Button(onClick = {
            viewModel.consumeAction(FirstScreenAction.LoadImportantData)
        }) {
            Text(text = "Get data")
        }
    }
}
