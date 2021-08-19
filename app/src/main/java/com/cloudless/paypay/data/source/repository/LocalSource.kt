package com.cloudless.paypay.data.source.repository

import com.cloudless.paypay.data.model.ChartModel
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    fun getAllProduct(): Flow<List<ChartModel>>
    suspend fun insert(chartModel: ChartModel)
    fun delete(chartModel: ChartModel)
    fun update(product: ChartModel)
}