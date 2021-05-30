package com.cloudless.paypay.data.source.remote

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cloudless.paypay.data.model.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper (private val context: Context) {
    companion object{
        const val BASE_URL: String = "https://neural-cortex-312716.df.r.appspot.com/"
    }

     fun login(loginModel: LoginModel): LiveData<String>{
         val isSucced = MutableLiveData<String>()
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiService::class.java)
        val loginCall = service.login(loginModel)
        loginCall.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                val isSucceded = response.body().toString()
                Log.d("login", response.body().toString())
                isSucced.postValue(isSucceded)
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                val isSucceded = "Fail : "+t.message
                Log.d("Login", isSucceded)
                isSucced.postValue(isSucceded)
            }
        })
        return isSucced
    }

    fun register(registerModel: RegisterModel): String {
        var isSucced = "false"
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val registerCall = service.register(registerModel)
        registerCall.enqueue(object : Callback<ApiResponseModel>{
            override fun onResponse(call: Call<ApiResponseModel>, response: Response<ApiResponseModel>) {
                isSucced = response.body().toString()
            }

            override fun onFailure(call: Call<ApiResponseModel>, t: Throwable) {
                isSucced = "Fail : "+t.message
                Log.d("Login", isSucced)
            }

        })
        return isSucced
    }

    fun getDetailUser(userId: String): UserModel {
        lateinit var userDetail: UserModel
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val userDetailCall = service.getUserDetail(userId)
        userDetailCall.enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                userDetail = UserModel(
                    response.body()?.id?:"null",
                    response.body()?.name?:"null",
                    response.body()?.email?:"null",
                    response.body()?.password?:"null"
                )
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                onErrorResponse(context, "getDetail fail : "+ t.message)
            }
        })
        return userDetail
    }

    fun getMerchantList(): List<MerchantModel>{
        val merchantList = ArrayList<MerchantModel>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val merchantListCall = service.getMerchantList()
        merchantListCall.enqueue(object : Callback<MerchantListModel> {
            override fun onResponse(
                call: Call<MerchantListModel>,
                response: Response<MerchantListModel>
            ) {
                if (response.body() != null) {
                    response.body()?.responseMerchant?.let { merchantList.addAll(it) }
                }
            }

            override fun onFailure(call: Call<MerchantListModel>, t: Throwable) {
                onErrorResponse(context, "getMerchantList error: "+t.message)
            }
        })
        return merchantList
    }

    fun getPromo(): List<PromoBanner>{
        val promoList = ArrayList<PromoBanner>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val promoBannerCall = service.getPromoBanner()
        promoBannerCall.enqueue(object : Callback<List<PromoBanner>> {
            override fun onResponse(call: Call<List<PromoBanner>>, response: Response<List<PromoBanner>>) {
                if (response.body() != null) {
                    response.body()?.let { promoList.addAll(it) }
                }
            }

            override fun onFailure(call: Call<List<PromoBanner>>, t: Throwable) {
                onErrorResponse(context, "getMerchantList error: "+t.message)
            }
        })
        return promoList
    }

    fun getMerchantPromo(): List<PromoItem>{
        val merchantPromoList = ArrayList<PromoItem>()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val merchantPromoCall = service.getPromoMerchant()
        merchantPromoCall.enqueue(object : Callback<ListPromo> {
            override fun onResponse(call: Call<ListPromo>, response: Response<ListPromo>) {
                if (response.body() != null) {
                    response.body()?.response?.let { merchantPromoList.addAll(it) }
                }
            }

            override fun onFailure(call: Call<ListPromo>, t: Throwable) {
                onErrorResponse(context, "getMerchantList error: "+t.message)
            }
        })
        return merchantPromoList
    }

    fun getProduct(identifier: String, merchant_id: String): ProductModel{
        lateinit var product: ProductModel
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val getProductCall = service.getProduct(identifier, merchant_id)
        getProductCall.enqueue(object : Callback<ProductModel> {
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                if (response.body() != null) {
                    product = ProductModel(
                        response.body()?.merchantId?:"-",
                        response.body()?.productName?:"-",
                        response.body()?.identifier?:"-",
                        response.body()?.price?:"-",
                        response.body()?.promoPrice?:"-",
                        response.body()?.imageProduct?:"-"
                    )
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