package com.entin.astraflex.data.mapper

import com.entin.astraflex.data.entity.ImportantDataEntity
import com.entin.astraflex.domain.model.ImportantData

fun ImportantDataEntity.toDomain() = ImportantData(
    id = this.id,
    name = this.name,
    subItems = this.subItems,
    createdAt = this.createdAt,
    isActive = this.isActive,
)
