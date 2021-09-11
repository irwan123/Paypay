package com.cloudless.paypay.data.source.repository

import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.data.source.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    fun getAllProduct(): Flow<List<ChartModel>>
    fun getHistory(): Flow<List<TransactionModel>>
    suspend fun insertHistory(transactionList: List<TransactionModel>)
    suspend fun insert(chartModel: ChartModel)
    fun delete(chartModel: ChartModel)
    fun update(product: ChartModel)
    suspend fun clearChart()
}