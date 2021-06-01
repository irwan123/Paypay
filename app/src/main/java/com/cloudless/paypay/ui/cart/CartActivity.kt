package com.cloudless.paypay.ui.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.ActivityCartBinding
import com.cloudless.paypay.ui.payment.PaymentActivity
import com.cloudless.paypay.viewmodel.ViewModelFactory

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
        val factory = ViewModelFactory.getInstance(this)
        cartViewModel = ViewModelProvider(this, factory)[CartViewModel::class.java]
        cartViewModel.getCartList().observe(this, ::setChart)

        cartBinding.btnCheckout.setOnClickListener {
            val intent = Intent(this@CartActivity, PaymentActivity::class.java)
            startActivity(intent)
        }

        cartAdapter.setOnDeleteItemListener(object : CartAdapter.OnDeleteProduct{
            override fun onDeleteItem(chartModel: ChartModel) {
                cartViewModel.delete(chartModel)
            }
        })
    }

    private fun setChart(result: List<ChartModel>){
        if (result.isEmpty()) {
            cartBinding.tvNoProduct.visibility = View.VISIBLE
        } else {
            cartAdapter.setCartItem(result)
            cartAdapter.notifyDataSetChanged()
            val total = result.sumBy{it.price}
            cartBinding.tvTotalPrice.text = "Total: "+total.toString()
        }
    }
}