package com.entin.astraflex.data.repository

import com.entin.astraflex.data.datasource.ImportantDataLocalSource
import com.entin.astraflex.data.datasource.ImportantDataLocalSourceImpl
import com.entin.astraflex.data.dto.ImportantDataDto
import com.entin.astraflex.data.mapper.toDomain
import com.entin.astraflex.domain.repository.ImportantDataLocalRepository

class ImportantDataLocalRepositoryImpl(
    private val importantDataLocalSource: ImportantDataLocalSource = ImportantDataLocalSourceImpl(),
) : ImportantDataLocalRepository {

    override suspend fun getAllImportantData(): ImportantDataDto {
        return try {
            ImportantDataDto.Success(
                importantDataLocalSource.getAllData().map {
                    it.toDomain()
                }
            )
        } catch (e: Exception) {
            ImportantDataDto.Fail
        }
    }
}
