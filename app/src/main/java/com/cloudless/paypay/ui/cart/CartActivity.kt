package com.cloudless.paypay.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private val cartAdapter = CartAdapter()
    private lateinit var cartBinding: ActivityCartBinding
    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(cartBinding.root)

        cartBinding.rvCart.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = cartAdapter
        }
        cartViewModel = ViewModelProvider(this@CartActivity,
            ViewModelProvider.NewInstanceFactory()).get(CartViewModel::class.java)
        val cartData = cartViewModel.getCartList()
        cartAdapter.setCartItem(cartData)
    }
}