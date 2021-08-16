package com.cloudless.paypay.data.source.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.cloudless.paypay.data.model.*
import com.cloudless.paypay.data.source.local.LocalDataSource
import com.cloudless.paypay.data.source.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class DataRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ): ApiDataSource, LocalSource {

    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData, localData).apply { instance = this }
                }
    }

    override fun login(loginModel: LoginModel): LiveData<UserModel> {
        return remoteDataSource.login(loginModel)
    }

    override fun register(registerModel: RegisterModel): LiveData<String> {
        return remoteDataSource.register(registerModel)
    }

    override fun getDetailUser(userId: String): LiveData<UserModel> {
        return remoteDataSource.getDetailUser(userId)
    }

    override fun getMerchantList(): LiveData<List<MerchantModel>> {
        return remoteDataSource.getMerchantList()
    }

    override fun getMerchantPromo(): LiveData<List<PromoItem>> {
        return remoteDataSource.getMerchantPromo()
    }

    override fun getProduct(identifier: String, merchant_id: String): LiveData<ProductModel> {
        return remoteDataSource.getProduct(identifier, merchant_id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override fun getAllProduct(): Flow<List<ChartModel>> {
        return localDataSource.getAllProduct()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(chartModel: ChartModel) {
        localDataSource.insert(chartModel)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun delete(chartModel: ChartModel) {
        localDataSource.delete(chartModel)
    }

    override fun update(id: Int, amount: Int, totalPrice: Int) {
        localDataSource.update(id, amount, totalPrice)
    }
}