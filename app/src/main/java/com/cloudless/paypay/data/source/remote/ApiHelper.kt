package com.cloudless.paypay.data.source.remote

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cloudless.paypay.data.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper (private val context: Context) {
    companion object{
        const val BASE_URL: String = "http://167.71.216.126:5000/"
    }

     fun login(loginModel: LoginModel): LiveData<UserModel>{
         val userDetail = MutableLiveData<UserModel>()
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiService::class.java)
        val loginCall = service.login(loginModel)
        loginCall.enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val user = UserModel(
                        response.body()!!.id,
                        response.body()?.name?:"null",
                        response.body()?.email?:"null",
                        response.body()?.pwd?:"null",
                        response.body()?.balance?:0
                )
                userDetail.postValue(user)
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                val isSucceded = "Fail : "+t.message
                Log.d("Login fail", isSucceded)
                onErrorResponse(context, isSucceded)
            }
        })
        return userDetail
    }

    fun register(registerModel: RegisterModel): LiveData<String> {
        val isSucced = MutableLiveData<String>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val registerCall = service.register(registerModel)
        registerCall.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                val isSucceded = response.body().toString()
                Log.d("login", response.body().toString())
                isSucced.postValue(isSucceded)
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                val isSucceded = "Fail : "+t.message
                Log.d("Login", isSucceded)
                onErrorResponse(context, isSucceded)
                isSucced.postValue(isSucceded)
            }

        })
        return isSucced
    }

    fun getDetailUser(userId: String): LiveData<UserModel> {
        val userDetail = MutableLiveData<UserModel>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val userDetailCall = service.getUserDetail(userId)
        userDetailCall.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                Log.d("response", response.toString())
                if (response.isSuccessful) {
                    val userResponse = UserModel(
                            response.body()!!.id,
                            response.body()?.name?:"null",
                            response.body()?.email?:"null",
                            response.body()?.pwd?:"null",
                            response.body()?.balance?:0
                    )
                    userDetail.postValue(userResponse)
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("response error", t.toString())
                onErrorResponse(context, "getDetail fail : " + t.message)
            }
        })
        return userDetail
    }

    fun getMerchantList(): LiveData<List<MerchantModel>>{
        val merchantList = MutableLiveData<List<MerchantModel>>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val merchantListCall = service.getMerchantList()
        merchantListCall.enqueue(object : Callback<List<MerchantModel>> {
            override fun onResponse(
                call: Call<List<MerchantModel>>,
                response: Response<List<MerchantModel>>
            ) {
                if (response.body() != null) {
                    val mMerchantList = ArrayList<MerchantModel>()
                    response.body()?.let { mMerchantList.addAll(it) }
                    merchantList.postValue(mMerchantList)
                }
            }

            override fun onFailure(call: Call<List<MerchantModel>>, t: Throwable) {
                onErrorResponse(context, "getMerchantList error: "+t.message)
            }
        })
        return merchantList
    }

    fun getMerchantPromo(): LiveData<List<PromoItem>>{
        val merchantPromoList = MutableLiveData<List<PromoItem>>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val merchantPromoCall = service.getPromoMerchant()
        merchantPromoCall.enqueue(object : Callback<List<PromoItem>> {
            override fun onResponse(call: Call<List<PromoItem>>, response: Response<List<PromoItem>>) {
                if (response.body() != null) {
                    val result = ArrayList<PromoItem>()
                    response.body()?.let { result.addAll(it) }
                    merchantPromoList.postValue(result)
                }
            }

            override fun onFailure(call: Call<List<PromoItem>>, t: Throwable) {
                onErrorResponse(context, "getMerchantList error: "+t.message)
            }
        })
        return merchantPromoList
    }

    fun getProduct(identifier: String, merchant_id: String): LiveData<ProductModel>{
        val mIdentifier: Int = Integer.parseInt(identifier)
        val product = MutableLiveData<ProductModel>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val getProductCall = service.getProduct(mIdentifier, merchant_id)
        getProductCall.enqueue(object : Callback<ProductModel> {
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                if (response.body() != null) {
                    val mProduct = ProductModel(
                        response.body()?.merchantId?:"-",
                        response.body()?.productName?:"-",
                        response.body()?.identifier?:"-",
                        response.body()?.price?:"-",
                        response.body()?.promoPrice?:"-",
                        response.body()?.imageProduct?:"-"
                    )
                    product.postValue(mProduct)
                } else {
                    onErrorResponse(context, "${response.body()}")
                }
            }

            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                onErrorResponse(context, "getMerchantList error: "+t.message)
            }

        })
        return product
    }

    fun onErrorResponse(context: Context, error: String){
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }
}