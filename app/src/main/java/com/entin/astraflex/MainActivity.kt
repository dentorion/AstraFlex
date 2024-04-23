package com.entin.astraflex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.entin.astraflex.domain.usecase.GetImportantDataUseCase
import com.entin.astraflex.presentation.screens.FirstScreen
import com.entin.astraflex.presentation.screens.FirstScreenViewModel
import com.entin.astraflex.ui.theme.AstraFlexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AstraFlexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: FirstScreenViewModel by viewModels { FirstScreenViewModel.Factory }
                    FirstScreen(viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AstraFlexTheme {
        FirstScreen(FirstScreenViewModel(GetImportantDataUseCase()))
    }
}