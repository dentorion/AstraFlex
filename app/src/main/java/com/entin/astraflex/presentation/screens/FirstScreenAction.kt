package com.entin.astraflex.presentation.screens

import com.entin.astraflex.core.mvi.ActionUi
import com.entin.astraflex.domain.model.ImportantData

sealed interface FirstScreenAction: ActionUi {

    data object LoadImportantData: FirstScreenAction

    // Internal

    data object ImportantDataLoading: FirstScreenAction

    data object ImportantDataFailed : FirstScreenAction

    data class ImportantDataHasLoaded(val data: List<ImportantData>) : FirstScreenAction
}