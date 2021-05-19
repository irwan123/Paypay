package com.cloudless.paypay.utils

import com.cloudless.paypay.R
import com.cloudless.paypay.data.CartModel
import com.cloudless.paypay.data.MerchantModel
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
    fun generateDummyMerchant(): List<MerchantModel>{
        val merchant = ArrayList<MerchantModel>()
        merchant.add(MerchantModel(
                "Alfamart",
                "Bandung",
                R.drawable.alfa)
        )
        merchant.add(MerchantModel(
                "Indomaret",
                "Jakarta",
                R.drawable.indomaret)
        )
        merchant.add(MerchantModel(
                "Griya",
                "Cipadung",
                R.drawable.griya)
        )
        merchant.add(MerchantModel(
                "Hypermart",
                "Buah Batu",
                R.drawable.hypermart)
        )
        return merchant
    }

    fun generateCartDummy(): List<CartModel>{
        val cart = ArrayList<CartModel>()
        cart.add(CartModel(
                "Aqua 600ml",
                R.drawable.aqua_promo,
                2000,
                1)
        )
        cart.add(CartModel(
                "Ultra Milk",
                R.drawable.ultramilk_promo,
                5000,
                1)
        )
        cart.add(CartModel(
                "Indomie Original",
                R.drawable.indomie_promo,
                3000,
                1)
        )
        cart.add(CartModel(
                "Oreo Original",
                R.drawable.aqua_promo,
                2000,
                1)
        )
        return cart
    }
}