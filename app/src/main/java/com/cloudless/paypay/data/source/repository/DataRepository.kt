package com.cloudless.paypay.data.source.repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.cloudless.paypay.data.model.*
import com.cloudless.paypay.data.source.local.LocalDataSource
import com.cloudless.paypay.data.source.remote.RemoteDataSource
import com.cloudless.paypay.utils.AppExecutor
import com.cloudless.paypay.utils.DataMapper
import kotlinx.coroutines.flow.*

class DataRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutor
    ): ApiDataSource, LocalSource {

    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutor: AppExecutor): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData, localData, appExecutor).apply { instance = this }
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
        return localDataSource.getAllProduct().map { DataMapper.ListEntityToModel(it) }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(chartModel: ChartModel) {
        localDataSource.insert(DataMapper.ModelToEntity(chartModel))
    }

    override fun delete(chartModel: ChartModel) {
        val product = DataMapper.ModelToEntity(chartModel)
        appExecutor.diskIO().execute { localDataSource.delete(product) }
    }

    override fun update(product: ChartModel) {
        val cartProduct = DataMapper.ModelToEntity(product)
        appExecutor.diskIO().execute{localDataSource.update(cartProduct)}
    }
}