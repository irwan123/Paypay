package com.cloudless.paypay.data.source.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    override fun getPromo(): LiveData<List<PromoBanner>> {
        val result = MutableLiveData<List<PromoBanner>>()
        val mResult = remoteDataSource.getPromo()
        result.postValue(mResult)
        return result
    }

    override fun getMerchantPromo(): LiveData<List<PromoItem>> {
        val result = MutableLiveData<List<PromoItem>>()
        val mResult = remoteDataSource.getMerchantPromo()
        result.postValue(mResult)
        return result
    }

    override fun getProduct(identifier: String, merchant_id: String): LiveData<ProductModel> {
        val result = MutableLiveData<ProductModel>()
        val mResult = remoteDataSource.getProduct(identifier, merchant_id)
        result.postValue(mResult)
        return result
    }
}