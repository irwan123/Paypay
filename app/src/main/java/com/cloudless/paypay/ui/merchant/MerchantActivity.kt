package com.cloudless.paypay.ui.merchant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.databinding.ActivityMerchantBinding
import com.cloudless.paypay.ui.addproduct.AddProductActivity

class MerchantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMerchantBinding
    private lateinit var merchantViewModel: MerchantViewModel
    private val merchantAdapter = MerchantAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMerchantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        merchantViewModel = ViewModelProvider(this@MerchantActivity,
            ViewModelProvider.NewInstanceFactory()).get(MerchantViewModel::class.java)

        binding.rvMerchant.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = merchantAdapter
        }
        val merchantList = merchantViewModel.getMerchant()
        merchantAdapter.setMerchant(merchantList)

        merchantAdapter.setOnClickedCallback(object : MerchantAdapter.OnclickItem{
            override fun onclickedItem(merchantId: String) {
                val intent = Intent(this@MerchantActivity, AddProductActivity::class.java)
                startActivity(intent)
            }

        })
    }
}