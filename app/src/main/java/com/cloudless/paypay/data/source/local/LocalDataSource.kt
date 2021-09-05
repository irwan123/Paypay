package com.cloudless.paypay.data.source.local

import com.cloudless.paypay.data.source.local.entity.ChartEntity
import com.cloudless.paypay.data.source.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val mChartDao: ChartDao){
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(chartDao: ChartDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(chartDao)
    }

    fun getAllProduct(): Flow<List<ChartEntity>> = mChartDao.getProductList()

    fun getHistory(): Flow<List<TransactionEntity>> = mChartDao.getHistory()

    suspend fun insertHistory(listTransaction: List<TransactionEntity>) = mChartDao.insertHistory(listTransaction)

    suspend fun insert(chart: ChartEntity) = mChartDao.insert(chart)

    fun delete(chart: ChartEntity) = mChartDao.delete(chart)

    fun update (product: ChartEntity) = mChartDao.update(product)
}