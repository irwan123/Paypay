package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

data class UserModel (

        @field:SerializedName("_id")
        val id: userId,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("email")
        val email: String,

        @field:SerializedName("pwd")
        val pwd: String,

        @field:SerializedName("balance")
        val balance: Int
)
data class userId(
        @field:SerializedName("$"+"oid")
        val oid: String? = null
)