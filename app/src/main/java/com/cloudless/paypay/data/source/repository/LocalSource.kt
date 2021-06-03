package com.cloudless.paypay.data.source.repository

import com.cloudless.paypay.data.model.ChartModel
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    fun getAllProduct(): Flow<List<ChartModel>>
    suspend fun insert(chartModel: ChartModel)
    suspend fun delete(chartModel: ChartModel)
    suspend fun update(id: Int, amount: Int, totalPrice: Int)
}