package com.cloudless.paypay.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloudless.paypay.data.model.NotificationModel
import com.cloudless.paypay.databinding.NotificationListItemBinding

class NotificationAdapter: RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    private val listNotificationItem = ArrayList<NotificationModel>()
    fun setNotificationItem(data: List<NotificationModel>?){
        if (data == null) return
        this.listNotificationItem.clear()
        this.listNotificationItem.addAll(data)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notificationItem = listNotificationItem[position]
        holder.bind(notificationItem)
    }
    override fun getItemCount(): Int = listNotificationItem.size

    inner class NotificationViewHolder(private val binding: NotificationListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind (notificationModel: NotificationModel){
            binding.tvTitle.text = notificationModel.title
            binding.tvDesc.text = notificationModel.desc
        }
    }



}