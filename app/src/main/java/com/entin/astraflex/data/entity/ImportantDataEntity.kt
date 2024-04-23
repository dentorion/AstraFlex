package com.entin.astraflex.data.entity

import java.time.LocalDateTime

data class ImportantDataEntity(
    val id: Long,
    val name: String,
    val subItems: List<Int>,
    val createdAt: LocalDateTime,
    val isActive: Boolean,
)
