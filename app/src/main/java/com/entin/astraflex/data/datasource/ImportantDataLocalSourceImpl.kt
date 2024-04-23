package com.entin.astraflex.data.datasource

import com.entin.astraflex.data.entity.ImportantDataEntity
import java.time.LocalDateTime

class ImportantDataLocalSourceImpl: ImportantDataLocalSource {

    override fun getAllData(): List<ImportantDataEntity> {
        return listOf(
            ImportantDataEntity(
                id = 4L,
                name = "Frantz",
                subItems = listOf(),
                createdAt = LocalDateTime.now(),
                isActive = true
            ),
            ImportantDataEntity(
                id = 7661L,
                name = "Kyra",
                subItems = listOf(),
                createdAt = LocalDateTime.now(),
                isActive = true
            ),
            ImportantDataEntity(
                id = 4269L,
                name = "Sylvan",
                subItems = listOf(),
                createdAt = LocalDateTime.now(),
                isActive = true
            ),
            ImportantDataEntity(
                id = 9380L,
                name = "Carolann",
                subItems = listOf(),
                createdAt = LocalDateTime.now(),
                isActive = false
            ),
            ImportantDataEntity(
                id = 4081L,
                name = "Tandi",
                subItems = listOf(),
                createdAt = LocalDateTime.now(),
                isActive = false
            ),
        )
    }
}
