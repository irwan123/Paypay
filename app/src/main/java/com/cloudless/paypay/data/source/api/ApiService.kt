package com.cloudless.paypay.data.source.api

import com.cloudless.paypay.data.model.ListPromo
import com.cloudless.paypay.data.model.MerchantListModel
import com.cloudless.paypay.data.model.MerchantModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("merchants")
    fun getMerchantList(): Call<MerchantListModel>

    @GET("promo")
    fun getPromoList(): Call<ListPromo>

    @GET("merchant?merchant_id=")
    fun getMerchantDetail(@Query("merchant_id") username: String): Call<MerchantModel>

    @GET("product/?identifier=&merchant_id=")
    fun getDetailProduct(@Query("identifier") username: String)
}