package com.entin.astraflex.domain.repository

import com.entin.astraflex.data.dto.ImportantDataDto

interface ImportantDataLocalRepository {

    suspend fun getAllImportantData(): ImportantDataDto
}