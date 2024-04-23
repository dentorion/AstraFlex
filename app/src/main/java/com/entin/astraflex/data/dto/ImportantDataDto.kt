package com.entin.astraflex.data.dto

import com.entin.astraflex.domain.model.ImportantData

sealed class ImportantDataDto {
    data class Success(val data: List<ImportantData>): ImportantDataDto()
    data object Fail: ImportantDataDto()
}
