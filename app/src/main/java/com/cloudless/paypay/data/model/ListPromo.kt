package com.cloudless.paypay.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ListPromo(

	@field:SerializedName("Response")
	val response: List<PromoItem>? = null
)

data class mechantId(

	@field:SerializedName("$"+"oid")
	val oid: String? = null
)

data class PromoItem(

	@field:SerializedName("identifier")
	val identifier: Int? = null,

	@field:SerializedName("on_promo")
	val onPromo: Boolean? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("promo_price")
	val promoPrice: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("merchant_name")
	val merchantName: String? = null,

	@field:SerializedName("_id")
	val id: Id? = null,

	@field:SerializedName("merchant_id")
	val merchantId: String? = null,

	@field:SerializedName("image_url")
	val imageProduct: String? = null
)

@Parcelize
data class PromoBanner(
	@field:SerializedName("image_url")
	val image_url: String? = null
): Parcelable
