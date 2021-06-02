package com.cloudless.paypay.di

import android.content.Context
import com.cloudless.paypay.data.source.local.ChartDatabase
import com.cloudless.paypay.data.source.local.LocalDataSource
import com.cloudless.paypay.data.source.remote.ApiHelper
import com.cloudless.paypay.data.source.remote.RemoteDataSource
import com.cloudless.paypay.data.source.repository.DataRepository

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val database = ChartDatabase.getDatabase(context)
        val localDataSource = LocalDataSource.getInstance(database.chartDao())
        val remoteDataSource = RemoteDataSource.getInstance(ApiHelper(context))

        return DataRepository.getInstance(remoteDataSource, localDataSource)
    }
}