package com.cloudless.paypay.ui.notification

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.NotificationModel
import com.cloudless.paypay.utils.DummyData

class NotificationViewModel: ViewModel(){
    fun getNotificationList(): List<NotificationModel> = DummyData.generateNotificationDummy()
}