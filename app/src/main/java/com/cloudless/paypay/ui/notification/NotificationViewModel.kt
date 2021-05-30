package com.cloudless.paypay.ui.notification

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.NotificationModel
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData

class NotificationViewModel(private val repository: DataRepository): ViewModel(){
    fun getNotificationList(): List<NotificationModel> = DummyData.generateNotificationDummy()
}