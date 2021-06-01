package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

class ProductModel (
        @field:SerializedName("merchant")
        var merchantId: String,

        @field:SerializedName("name")
        var productName: String,

        @field:SerializedName("identifier")
        var identifier: String,

        @field:SerializedName("price")
        var price: String,

        @field:SerializedName("promo_price")
        var promoPrice: String,

        @field:SerializedName("image_url")
        var imageProduct: String
        )