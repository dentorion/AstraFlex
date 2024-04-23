package com.entin.astraflex.domain.model

import java.time.LocalDateTime

data class ImportantData(
    val id: Long,
    val name: String,
    val subItems: List<Int>,
    val createdAt: LocalDateTime,
    val isActive: Boolean,
)
