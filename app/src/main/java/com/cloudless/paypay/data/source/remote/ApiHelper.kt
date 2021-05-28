package com.cloudless.paypay.data.source.remote

import android.content.Context
import com.cloudless.paypay.BuildConfig
import com.cloudless.paypay.data.model.LoginModel
import com.cloudless.paypay.data.model.UserModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper(context: Context) {

    fun login(loginModel: LoginModel){
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiService::class.java)
        val userListCall = service.login(loginModel)
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