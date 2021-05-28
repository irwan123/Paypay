package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

class LoginModel (
    @field:SerializedName("name")
    var name: String,
    @field:SerializedName("pwd")
    var password: String
)
