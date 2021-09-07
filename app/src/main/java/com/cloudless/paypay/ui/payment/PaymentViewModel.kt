package com.cloudless.paypay.ui.payment

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.viewmodel.ViewModelFactory

class PaymentViewModel(private val repository: DataRepository): ViewModel() {
    fun uploadTransaction(listData: List<TransactionModel>) = repository.insertTransaction(listData)
}