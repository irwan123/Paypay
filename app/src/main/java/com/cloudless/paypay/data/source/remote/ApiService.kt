package com.cloudless.paypay.data.source.remote

import com.cloudless.paypay.data.model.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("login")
    fun login(@Body loginModel: LoginModel): Call<String>

    @POST
    fun register(@Body registerModel: RegisterModel): Call<ApiResponseModel>

    @GET("user?user_id")
    fun getUserDetail(@Query("user_id") userId: String): Call<UserModel>

    @GET("merchants")
    fun getMerchantList(): Call<MerchantListModel>

    @GET("promo")
    fun getPromoMerchant(): Call<ListPromo>

    @GET("promo_banner")
    fun getPromoBanner(): Call<List<PromoBanner>>

    @GET("merchant?merchant_id=")
    fun getMerchantDetail(@Query("merchant_id") username: String): Call<MerchantModel>

    @GET("product/?identifier=&merchant_id=")
    fun getProduct(@Query("identifier") identifier: String, @Query("merchant_id") merchant_id: String): Call<ProductModel>

}