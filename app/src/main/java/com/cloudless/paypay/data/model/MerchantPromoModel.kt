package com.cloudless.paypay.data.model

data class MerchantPromoModel (
    var merchantName: String,
    var productName: String,
    var imageProduct: Int,
    var price: Int,
    var pricePromo: Int
    )