package com.cloudless.paypay.ui.cart

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.CartModel
import com.cloudless.paypay.utils.DummyData

class CartViewModel: ViewModel() {
    fun getCartList(): List<CartModel> = DummyData.generateCartDummy()
}