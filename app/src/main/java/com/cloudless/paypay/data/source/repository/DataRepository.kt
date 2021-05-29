package com.cloudless.paypay.data.source.repository

import androidx.lifecycle.LiveData
import com.cloudless.paypay.data.model.*
import com.cloudless.paypay.data.source.remote.RemoteDataSource

class DataRepository private constructor(private val remoteDataSource: RemoteDataSource): ApiDataSource {
    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(remoteData: RemoteDataSource): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData).apply { instance = this }
                }
    }

    override fun login(loginModel: LoginModel): LiveData<String> {
        TODO("Not yet implemented")
    }

    override fun register(registerModel: RegisterModel): LiveData<String> {
        TODO("Not yet implemented")
    }

    override fun getDetailUser(userId: String): LiveData<UserModel> {
        TODO("Not yet implemented")
    }

    override fun getMerchantList(): LiveData<List<MerchantModel>> {
        TODO("Not yet implemented")
    }

    override fun getPromo(): LiveData<List<PromoBanner>> {
        TODO("Not yet implemented")
    }

    override fun getMerchantPromo(): LiveData<List<PromoItem>> {
        TODO("Not yet implemented")
    }

    override fun getProduct(identifier: String, merchant_id: String): LiveData<ProductModel> {
        TODO("Not yet implemented")
    }
}