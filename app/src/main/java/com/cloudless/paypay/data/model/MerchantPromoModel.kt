package com.cloudless.paypay.data.model

//no longer use, need to check all useable of this model and change to PromoItem data class at ListPromo model
data class MerchantPromoModel (
    var merchantName: String,
    var identifier: String,
    var productName: String,
    var imageProduct: Int,
    var price: Int,
    var pricePromo: Int
    )