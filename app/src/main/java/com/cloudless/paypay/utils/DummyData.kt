package com.cloudless.paypay.utils

import com.cloudless.paypay.data.model.FavoriteModel
import com.cloudless.paypay.data.model.NotificationModel

object DummyData {
    /*
    fun generateDummyMerchant(): List<MerchantModel>{
        val merchant = ArrayList<MerchantModel>()
        merchant.add(MerchantModel(
                Id("1"),
                "Alfamart",
                "Bandung",
                "R.drawable.hypermart")
        )
        merchant.add(MerchantModel(
                Id("1"),
                "Alfamart",
                "Jakarta",
                "R.drawable.hypermart")
        )
        merchant.add(MerchantModel(
                Id("1"),
                "Alfamart",
                "Cipadung",
                "R.drawable.hypermart")
        )
        merchant.add(MerchantModel(
                Id("1"),
                "Alfamart",
                "Buah Batu",
                "R.drawable.hypermart")
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
*/
    fun generateFavoriteDummy(): List<FavoriteModel>{
        val favorite = ArrayList<FavoriteModel>()
        favorite.add(FavoriteModel(
                "Aqua 600ml",
                "https://raw.githubusercontent.com/adityaids/image_dummy/main/aqua_produk.jpg",
                2000, )
        )
        favorite.add(FavoriteModel(
                "Ultra Milk",
                "https://raw.githubusercontent.com/adityaids/image_dummy/main/ultramilk_produk.jpg",
                5000, )
        )
        favorite.add(FavoriteModel(
                "Indomie Original",
                "https://raw.githubusercontent.com/adityaids/image_dummy/main/indomie_produk.png",
                3000,)
        )
        favorite.add(FavoriteModel(
                "Oreo Original",
                "https://raw.githubusercontent.com/adityaids/image_dummy/main/oreo_produk.jpg",
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