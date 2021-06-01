package com.cloudless.paypay.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.model.ProductModel
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val mChartDao: ChartDao){
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(chartDao: ChartDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(chartDao)
    }

    fun getAllProduct(): Flow<List<ChartModel>> = mChartDao.getProductList()

    suspend fun insert(chartModel: ChartModel) = mChartDao.insert(chartModel)

    suspend fun delete(chartModel: ChartModel) = mChartDao.delete(chartModel)
}