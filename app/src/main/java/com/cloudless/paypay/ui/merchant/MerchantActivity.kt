package com.cloudless.paypay.ui.merchant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.databinding.ActivityMerchantBinding

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
    }
}