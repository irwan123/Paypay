package com.cloudless.paypay.ui.merchant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.data.model.MerchantModel
import com.cloudless.paypay.databinding.ActivityMerchantBinding
import com.cloudless.paypay.ui.addproduct.AddProductActivity
import com.cloudless.paypay.ui.addproduct.AddProductActivity.Companion.MERCHANT_ID
import com.cloudless.paypay.viewmodel.ViewModelFactory

class MerchantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMerchantBinding
    private lateinit var merchantViewModel: MerchantViewModel
    private val merchantAdapter = MerchantAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMerchantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pgsBar.visibility = View.VISIBLE
        val factory = ViewModelFactory.getInstance(this)
        merchantViewModel = ViewModelProvider(this@MerchantActivity,
            factory)[MerchantViewModel::class.java]

        binding.rvMerchant.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = merchantAdapter
        }
        merchantViewModel.getMerchant().observe(this, ::setMerchant)

        merchantAdapter.setOnClickedCallback(object : MerchantAdapter.OnclickItem{
            override fun onclickedItem(merchantId: String) {
                val intent = Intent(this@MerchantActivity, AddProductActivity::class.java).apply {
                    putExtra(MERCHANT_ID, merchantId)
                }
                startActivity(intent)
            }
        })
    }

    private fun setMerchant(merchantList: List<MerchantModel>){
        merchantAdapter.setMerchant(merchantList)
        merchantAdapter.notifyDataSetChanged()
        binding.pgsBar.visibility = View.GONE
    }
}