package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

class UserModel (


        @field:SerializedName("_id")
        val id: Id,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("email")
        val email: String,

        @field:SerializedName("pwd")
        val pwd: String,

        @field:SerializedName("balance")
        val balance: Int
        )