package com.cloudless.paypay.data.source.remote


import androidx.lifecycle.LiveData
import com.cloudless.paypay.data.model.*

class RemoteDataSource private constructor (private val apiHelper: ApiHelper){

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(apiHelper: ApiHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(apiHelper).apply { instance = this }
                }
    }

    fun login(loginModel: LoginModel): LiveData<UserModel>{
        return apiHelper.login(loginModel)
    }

    fun register(registerModel: RegisterModel): LiveData<String>{
        return apiHelper.register(registerModel)
    }

    fun getDetailUser(userId: String): LiveData<UserModel>{
        return apiHelper.getDetailUser(userId)
    }

    fun getMerchantList(): LiveData<List<MerchantModel>>{
        return apiHelper.getMerchantList()
    }

    fun getMerchantPromo(): LiveData<List<PromoItem>>{
        return apiHelper.getMerchantPromo()
    }

    fun insertTransaction(transcationList: List<TransactionModel>): LiveData<String> =
        apiHelper.insertTransaction(transcationList)

    fun getHistoryFromNet(userId: String): LiveData<List<TransactionModel>> =
        apiHelper.getTransaction(userId)

    fun getProduct(identifier: String, merchant_id: String): LiveData<ProductModel>{
        return apiHelper.getProduct(identifier, merchant_id)
    }
}