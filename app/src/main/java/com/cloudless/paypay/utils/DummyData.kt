package com.cloudless.paypay.utils

import com.cloudless.paypay.R
import com.cloudless.paypay.data.*

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
                R.drawable.oreo_promo,
                2000,
                1)
        )
        return cart
    }

    fun generateFavoriteDummy(): List<FavoriteModel>{
        val favorite = ArrayList<FavoriteModel>()
        favorite.add(FavoriteModel(
                "Aqua 600ml",
                R.drawable.aqua_promo,
                2000, )
        )
        favorite.add(FavoriteModel(
                "Ultra Milk",
                R.drawable.ultramilk_promo,
                5000, )
        )
        favorite.add(FavoriteModel(
                "Indomie Original",
                R.drawable.indomie_promo,
                3000,)
        )
        favorite.add(FavoriteModel(
                "Oreo Original",
                R.drawable.oreo_promo,
                2000,)
        )
        return favorite
    }

    fun generateNotificationDummy(): List<NotificationModel>{
        val notification = ArrayList<NotificationModel>()
        notification.add(NotificationModel(
                "Promo dan Update PayPay!",
                "Deskripsi tentang promo")
        )
        notification.add(NotificationModel(
                "Feed",
                "Deskripsi tentang Feed")
        )
        notification.add(NotificationModel(
                "Aktivitas",
                "Deskripsi tentang Aktivitas")
        )
        notification.add(NotificationModel(
                "Promo dan Update Merchant",
                "Deskripsi tentang merchant")
        )
        notification.add(NotificationModel(
                "Merchant Baru",
                "Deskripsi tentang merchant baru")
        )
        notification.add(NotificationModel(
                "Info Pengguna",
                "Deskripsi tentang info pengguna")
        )
        return notification
    }
}