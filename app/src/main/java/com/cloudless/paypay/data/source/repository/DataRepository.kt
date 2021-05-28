package com.cloudless.paypay.data.source.repository

import com.cloudless.paypay.data.source.remote.RemoteDataSource

class DataRepository private constructor(private val remoteDataSource: RemoteDataSource) : ApiDataSource {
    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteData: RemoteDataSource): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData).apply { instance = this }
                }
    }
}