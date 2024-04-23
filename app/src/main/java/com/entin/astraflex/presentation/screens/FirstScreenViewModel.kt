package com.entin.astraflex.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.entin.astraflex.core.mvi.ActionConsumer
import com.entin.astraflex.core.mvi.ActionUi
import com.entin.astraflex.core.mvi.StateHolder
import com.entin.astraflex.core.mvi.UiState
import com.entin.astraflex.domain.usecase.GetImportantDataUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstScreenViewModel(
    private val useCase: GetImportantDataUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel(), ActionConsumer, StateHolder {

    private val _state = MutableStateFlow(FirstScreenUiState())
    override val state: StateFlow<UiState> = _state.asStateFlow()

    private val _action = MutableSharedFlow<FirstScreenAction>(extraBufferCapacity = 1)

    init {
        viewModelScope.launch {
            _action.collect { action ->
                val currentState = _state.value

                _state.value = reduce(currentState, action)

                withContext(ioDispatcher) {
                    dispatch(action)
                }
            }
        }
    }

    private suspend fun dispatch(action: FirstScreenAction) {
        when(action) {
            FirstScreenAction.LoadImportantData -> loadImportantData()
            else -> Unit
        }
    }

    private fun reduce(
        currentState: FirstScreenUiState,
        action: FirstScreenAction,
    ): FirstScreenUiState {
        return when (action) {
            is FirstScreenAction.ImportantDataHasLoaded -> currentState.copy(listImportantData = action.data)
            FirstScreenAction.LoadImportantData -> currentState.copy(isLoading = true)
            FirstScreenAction.ImportantDataFailed -> currentState.copy(isLoading = false, isError = true)
            else -> currentState
        }
    }

    override fun consumeAction(action: ActionUi) {
        _action.tryEmit(action as FirstScreenAction)
    }

    private suspend fun loadImportantData() {
        val data = useCase.invoke()
        consumeAction(FirstScreenAction.ImportantDataHasLoaded(data))
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                FirstScreenViewModel(
                    GetImportantDataUseCase()
                )
            }
        }
    }
}