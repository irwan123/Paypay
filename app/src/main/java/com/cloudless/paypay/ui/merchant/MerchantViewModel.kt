package com.cloudless.paypay.ui.merchant

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.MerchantModel
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData

class MerchantViewModel(private val repository: DataRepository): ViewModel() {
    // fun getMerchant(): List<MerchantModel> = DummyData.generateDummyMerchant()

    fun getMerchant(): LiveData<List<MerchantModel>> = repository.getMerchantList()
}