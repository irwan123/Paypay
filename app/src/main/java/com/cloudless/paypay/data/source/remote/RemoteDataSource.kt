package com.cloudless.paypay.data.source.remote


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

    fun login(loginModel: LoginModel): String{
        return apiHelper.login(loginModel)
    }

    fun register(registerModel: RegisterModel): String{
        return apiHelper.register(registerModel)
    }

    fun getDetailUser(userId: String): UserModel{
        return apiHelper.getDetailUser(userId)
    }

    fun getMerchantList(): List<MerchantModel>{
        return apiHelper.getMerchantList()
    }

    fun getPromo(): List<PromoBanner>{
        return apiHelper.getPromo()
    }

    fun getMerchantPromo(): List<PromoItem>{
        return apiHelper.getMerchantPromo()
    }

    fun getProduct(identifier: String, merchant_id: String): ProductModel{
        return apiHelper.getProduct(identifier, merchant_id)
    }
}