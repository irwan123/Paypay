package com.cloudless.paypay.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.viewmodel.ViewModelFactory
import kotlinx.coroutines.launch

class PaymentViewModel(private val repository: DataRepository): ViewModel() {
    fun uploadTransaction(listData: List<TransactionModel>) = repository.insertTransaction(listData)
    fun clearChart(){
        viewModelScope.launch {
            repository.clearChart()
        }
    }
}