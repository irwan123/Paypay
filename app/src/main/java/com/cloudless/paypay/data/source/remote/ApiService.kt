package com.cloudless.paypay.data.source.remote

import com.cloudless.paypay.data.model.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("login")
    fun login(@Body loginModel: LoginModel)

    @POST
    fun register(@Body registerModel: RegisterModel)

    @GET("user?user_id")
    fun getUserDetail(@Query("user_id") userId: String): Call<UserModel>

    @GET("merchants")
    fun getMerchantList(): Call<MerchantListModel>

    @GET("promo")
    fun getPromoList(): Call<ListPromo>

    @GET("merchant?merchant_id=")
    fun getMerchantDetail(@Query("merchant_id") username: String): Call<MerchantModel>

    @GET("product/?identifier=&merchant_id=")
    fun getProduct(@Query("identifier") username: String, @Query("merchant_id") merchant_id: String)

}