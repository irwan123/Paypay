package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

class MerchantModel (
        @field:SerializedName("name")
        var merchantName: String,

        @field:SerializedName("location")
        var location: String,

        @field:SerializedName("image_merchant")
        var merchantPhoto: String
        )