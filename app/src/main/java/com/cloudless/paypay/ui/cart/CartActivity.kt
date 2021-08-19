package com.cloudless.paypay.ui.cart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.ActivityCartBinding
import com.cloudless.paypay.ui.payment.PaymentActivity
import com.cloudless.paypay.ui.payment.PaymentActivity.Companion.EXTRA_CHECKOUT
import com.cloudless.paypay.viewmodel.ViewModelFactory

class CartActivity : AppCompatActivity() {

    private val cartAdapter = CartAdapter()
    private lateinit var cartBinding: ActivityCartBinding
    private lateinit var cartViewModel: CartViewModel
    private val checkoutList = ArrayList<ChartModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(cartBinding.root)

        cartBinding.rvCart.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = cartAdapter
        }
        val factory = ViewModelFactory.getInstance(this)
        cartViewModel = ViewModelProvider(this, factory)[CartViewModel::class.java]
        cartViewModel.getCartList().observe(this, { result ->
            if (result != null) {
                checkoutList.clear()
                checkoutList.addAll(result)
                cartAdapter.setCartItem(result)
                val total = result.sumBy{it.totalPrice}
                cartBinding.tvTotalPrice.text = "Total: "+total.toString()
            }
            if(result.isEmpty()){
                cartBinding.tvNoProduct.visibility = View.VISIBLE
            }
        })

        cartBinding.btnCheckout.setOnClickListener {
            checkout(checkoutList)
        }

        cartAdapter.setOnDeleteItemListener(object : CartAdapter.OnDeleteProduct {
            override fun onDeleteItem(chartModel: ChartModel) {
                cartViewModel.delete(chartModel)
            }
        })

        cartAdapter.setOnUpdateProduct(object : CartAdapter.OnUpdateProduct{
            override fun onUpdate(chartModel: ChartModel) {
                cartViewModel.update(chartModel)
            }
        })
    }

    private fun checkout(result: ArrayList<ChartModel>){
        val intent = Intent(this@CartActivity, PaymentActivity::class.java).apply {
            putExtra(EXTRA_CHECKOUT, result)
        }
        startActivity(intent)
    }
}