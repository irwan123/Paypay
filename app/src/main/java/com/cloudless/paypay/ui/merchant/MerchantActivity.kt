package com.cloudless.paypay.ui.merchant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.MerchantListModel
import com.cloudless.paypay.ui.merchant.MerchantViewModel
import com.cloudless.paypay.data.model.MerchantModel
import com.cloudless.paypay.databinding.ActivityMerchantBinding
import com.cloudless.paypay.ui.addproduct.AddProductActivity
import com.cloudless.paypay.ui.addproduct.AddProductFragment
import com.cloudless.paypay.ui.login.LoginActivity
import com.cloudless.paypay.ui.login.LoginFragment

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
        merchantAdapter.setOnItemClickCallback(object : MerchantAdapter.OnItemClickItem{
            override fun onItemClicked(merchantId: String) {
                val intent = Intent(this@MerchantActivity, AddProductActivity::class.java)
                startActivity(intent)
            }
        })
    }

}