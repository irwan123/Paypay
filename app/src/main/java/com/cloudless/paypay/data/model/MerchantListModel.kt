package com.cloudless.paypay.data.model

import com.google.gson.annotations.SerializedName

data class MerchantListModel(
		val responseMerchant: ArrayList<MerchantModel>? = null
)

data class Id(
		@field:SerializedName("$"+"oid")
		val oid: String? = null
)

data class MerchantModel (
		@field:SerializedName("_id")
		var id: Id,

		@field:SerializedName("name")
		var merchantName: String,

		@field:SerializedName("location")
		var location: String,

		@field:SerializedName("image_url")
		var merchantPhoto: String?
)

