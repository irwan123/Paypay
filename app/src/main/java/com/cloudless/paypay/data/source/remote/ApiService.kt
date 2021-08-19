package com.cloudless.paypay.data.source.remote

import com.cloudless.paypay.data.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("login")
    fun login(@Body loginModel: LoginModel): Call<UserModel>

    @POST("user")
    fun register(@Body registerModel: RegisterModel): Call<String>

    @GET("user?")
    fun getUserDetail(@Query("user_id") userId: String): Call<UserModel>

    @GET("merchants")
    fun getMerchantList(): Call<List<MerchantModel>>

    @GET("promo")
    fun getPromoMerchant(): Call<List<PromoItem>>

    @GET("product")
    fun getProduct(@Query("identifier") identifier: Int, @Query("merchant_id") merchant_id: String): Call<ProductModel>

}