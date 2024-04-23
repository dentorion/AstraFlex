package com.entin.astraflex.domain.usecase

import com.entin.astraflex.data.dto.ImportantDataDto
import com.entin.astraflex.data.repository.ImportantDataLocalRepositoryImpl
import com.entin.astraflex.domain.model.ImportantData
import com.entin.astraflex.domain.repository.ImportantDataLocalRepository

class GetImportantDataUseCase(
    private val importantDataLocalRepository: ImportantDataLocalRepository = ImportantDataLocalRepositoryImpl(),
) {

    suspend operator fun invoke(): List<ImportantData> {
        return when (val dto = importantDataLocalRepository.getAllImportantData()) {
            ImportantDataDto.Fail -> emptyList()
            is ImportantDataDto.Success -> dto.data
        }
    }
}
