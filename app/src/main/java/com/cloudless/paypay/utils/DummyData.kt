package com.cloudless.paypay.utils

import com.cloudless.paypay.R
import com.cloudless.paypay.data.MerchantPromoModel

object DummyData {
    fun generateDummyPromo(): List<MerchantPromoModel>{
        val promo = ArrayList<MerchantPromoModel>()

        promo.add(
            MerchantPromoModel(
            "Indomaret",
            "Aqua 600ml",
                R.drawable.aqua_promo,
                2000,
                1500)
        )
        promo.add(
            MerchantPromoModel(
                "Hypermart",
                "Oreo original",
                R.drawable.oreo_promo,
                3000,
                2000)
        )
        promo.add(
            MerchantPromoModel(
                "Alfamart",
                "Ultra Milk 250ml",
                R.drawable.ultramilk_promo,
                5000,
                4500)
        )
        promo.add(
            MerchantPromoModel(
                "Griya",
                "Indomie Original",
                R.drawable.indomie_promo,
                3000,
                2000)
        )
        return promo
    }
}