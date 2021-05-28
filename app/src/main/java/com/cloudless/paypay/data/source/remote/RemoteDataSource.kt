package com.cloudless.paypay.data.source.remote

import com.cloudless.paypay.data.model.UserModel

class RemoteDataSource private constructor (apiHelper: ApiHelper){

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(apiHelper: ApiHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(apiHelper).apply { instance = this }
                }
    }

    fun login(email: String, password: String){

    }

    fun register(userModel: UserModel){

    }

    fun getDetailUser(userId: String){

    }

    fun getMerchantList(){

    }

    fun getPromo(){

    }

    fun getMerchantPromo(merchant_id: String){

    }

    fun getProduct(identifier: String, merchant_id: String){

    }

}