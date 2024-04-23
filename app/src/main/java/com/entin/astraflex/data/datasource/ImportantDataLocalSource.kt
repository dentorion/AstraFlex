package com.entin.astraflex.data.datasource

import com.entin.astraflex.data.entity.ImportantDataEntity

interface ImportantDataLocalSource {

    fun getAllData(): List<ImportantDataEntity>
}
