package com.cloudless.paypay.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChartModel (
        var id: Int = 0,
        var merchantId: String? = "",
        var productName: String? = "",
        var imageProduct: String? = "",
        var price: Int = 0,
        var amount: Int = 0,
        var totalPrice: Int = 0
): Parcelable