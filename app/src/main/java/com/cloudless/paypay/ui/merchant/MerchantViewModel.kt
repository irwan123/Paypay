package com.cloudless.paypay.ui.merchant

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.MerchantModel
import com.cloudless.paypay.utils.DummyData

class MerchantViewModel: ViewModel() {
    fun getMerchant(): List<MerchantModel> = DummyData.generateDummyMerchant()
}