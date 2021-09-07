package com.cloudless.paypay.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cloudless.paypay.data.model.*
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository): ViewModel() {
    fun getMerchantPromo(): LiveData<List<PromoItem>> = repository.getMerchantPromo()
    fun getDetailUser(userId: String): LiveData<UserModel> = repository.getDetailUser(userId)
    fun getFavoritList() = DummyData.generateFavoriteDummy()
    fun getNotificationList(): List<NotificationModel> = DummyData.generateNotificationDummy()
    fun getHistoryFromNet(userId: String): LiveData<List<TransactionModel>> = repository.getHistoryFromNet(userId)
    fun insertHistory(listHistory: List<TransactionModel>){
        viewModelScope.launch {
            repository.insertHistory(listHistory)
        }
    }
}