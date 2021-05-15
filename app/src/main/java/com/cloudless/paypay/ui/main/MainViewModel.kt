package com.cloudless.paypay.ui.main

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.MerchantPromoModel
import com.cloudless.paypay.utils.DummyData

class MainViewModel: ViewModel() {

    fun getPromo(): List<MerchantPromoModel> = DummyData.generateDummyPromo()
}