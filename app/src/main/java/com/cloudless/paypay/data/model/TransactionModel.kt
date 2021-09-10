package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

data class TransactionModel(
    var id: Int = 0,
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("merchant_id")
    var merchantId: String,
    @SerializedName("product_name")
    var product: String,
    @SerializedName("product_image")
    var imageProduct: String,
    @SerializedName("amount")
    var amount: Int = 0,
    @SerializedName("price")
    var price: Int = 0,
    @SerializedName("total_price")
    var totalPrice: Int = 0,
    @SerializedName("status")
    var status: String
)