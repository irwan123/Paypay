package com.cloudless.paypay.di

import android.content.Context
import com.cloudless.paypay.data.source.remote.ApiHelper
import com.cloudless.paypay.data.source.remote.ApiService
import com.cloudless.paypay.data.source.remote.RemoteDataSource
import com.cloudless.paypay.data.source.repository.DataRepository

object Injection {
    fun provideRepository(context: Context): DataRepository {

        val remoteDataSource = RemoteDataSource.getInstance(ApiHelper(context))

        return DataRepository.getInstance(remoteDataSource)
    }
}