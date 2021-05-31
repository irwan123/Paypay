package com.cloudless.paypay.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.MerchantPromoModel
import com.cloudless.paypay.data.model.PromoItem
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData

class MainViewModel(private val repository: DataRepository): ViewModel() {

    // fun getPromo(): List<MerchantPromoModel> = DummyData.generateDummyPromo()
    fun getMerchantPromo(): LiveData<List<PromoItem>> = repository.getMerchantPromo()
}