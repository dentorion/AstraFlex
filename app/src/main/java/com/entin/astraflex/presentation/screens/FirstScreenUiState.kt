package com.entin.astraflex.presentation.screens

import com.entin.astraflex.core.mvi.UiState
import com.entin.astraflex.domain.model.ImportantData

data class FirstScreenUiState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val listImportantData: List<ImportantData> = emptyList(),
): UiState
