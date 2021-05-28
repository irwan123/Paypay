package com.cloudless.paypay.data.source.repository

import androidx.lifecycle.LiveData
import com.cloudless.paypay.data.model.*

interface ApiDataSource {
    fun login(loginModel: LoginModel): LiveData<String>
    fun register(registerModel: RegisterModel): LiveData<String>
    fun getDetailUser(userId: String): LiveData<UserModel>
    fun getMerchantList(): LiveData<List<MerchantModel>>
    fun getPromo(): LiveData<List<PromoBanner>>
    fun getMerchantPromo(): LiveData<List<PromoItem>>
    fun getProduct(identifier: String, merchant_id: String): LiveData<ProductModel>
}