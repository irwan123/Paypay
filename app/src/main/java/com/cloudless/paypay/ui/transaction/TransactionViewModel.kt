package com.cloudless.paypay.ui.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.data.source.repository.DataRepository

class TransactionViewModel(private val repository: DataRepository): ViewModel() {
    fun getHistory(): LiveData<List<TransactionModel>> = repository.getHistory().asLiveData()
}