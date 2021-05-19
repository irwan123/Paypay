package com.cloudless.paypay.ui.main

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.CartModel
import com.cloudless.paypay.data.MerchantModel
import com.cloudless.paypay.data.MerchantPromoModel
import com.cloudless.paypay.utils.DummyData

class MainViewModel: ViewModel() {

    fun getPromo(): List<MerchantPromoModel> = DummyData.generateDummyPromo()
    fun getMerchant(): List<MerchantModel> = DummyData.generateDummyMerchant()
}