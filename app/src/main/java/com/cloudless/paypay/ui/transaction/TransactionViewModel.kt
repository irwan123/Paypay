package com.cloudless.paypay.ui.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.data.source.repository.DataRepository
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: DataRepository): ViewModel() {
    fun getHistory(): LiveData<List<TransactionModel>> = repository.getHistory().asLiveData()
    fun getHistoryFromNet(userId: String): LiveData<List<TransactionModel>> = repository.getHistoryFromNet(userId)
    fun insertHistory(listHistory: List<TransactionModel>){
        viewModelScope.launch {
            repository.insertHistory(listHistory)
        }
    }
}