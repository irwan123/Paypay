package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

data class TransactionModel(
    var id: Int = 0,
    @SerializedName("userId")
    var userId: String,
    @SerializedName("merchantId")
    var merchantId: String,
    @SerializedName("product")
    var product: String,
    @SerializedName("image_product")
    var imageProduct: String,
    @SerializedName("amount")
    var amount: Int = 0,
    @SerializedName("price")
    var price: Int = 0,
    @SerializedName("totalPrice")
    var totalPrice: Int = 0,
    @SerializedName("status")
    var status: String
)