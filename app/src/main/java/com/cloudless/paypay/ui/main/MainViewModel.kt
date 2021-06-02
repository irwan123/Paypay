package com.cloudless.paypay.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.*
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData

class MainViewModel(private val repository: DataRepository): ViewModel() {
    fun getMerchantPromo(): LiveData<List<PromoItem>> = repository.getMerchantPromo()
    fun getDetailUser(userId: String): LiveData<UserModel> = repository.getDetailUser(userId)
    fun getFavoritList() = DummyData.generateFavoriteDummy()
    fun getNotificationList(): List<NotificationModel> = DummyData.generateNotificationDummy()
}