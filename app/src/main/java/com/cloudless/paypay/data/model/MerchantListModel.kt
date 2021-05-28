package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

data class MerchantListModel(
		@field:SerializedName("items")
		val responseMerchant: ArrayList<MerchantModel>? = null
)

data class Id(
		@field:SerializedName("$0id")
		val oid: String? = null
)

data class MerchantModel (
		@field:SerializedName("$0id")
		var id: Id,

		@field:SerializedName("name")
		var merchantName: String,

		@field:SerializedName("location")
		var location: String,

		@field:SerializedName("image_merchant")
		var merchantPhoto: String
)

