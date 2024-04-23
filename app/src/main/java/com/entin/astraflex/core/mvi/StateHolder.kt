package com.entin.astraflex.core.mvi

import kotlinx.coroutines.flow.StateFlow

interface StateHolder {
    val state: StateFlow<UiState>
}
