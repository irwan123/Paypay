package com.cloudless.paypay.ui.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.databinding.FragmentNotificationsBinding
import com.cloudless.paypay.ui.main.MainViewModel
import com.cloudless.paypay.viewmodel.ViewModelFactory


class NotificationsFragment : Fragment() {
    private lateinit var binding: FragmentNotificationsBinding
    private val notificationAdapter = NotificationAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(layoutInflater, container, false)
        binding.rvNotification.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = notificationAdapter
        }
        val factory = ViewModelFactory.getInstance(requireContext())
        val viewModel = ViewModelProvider(requireActivity(), factory)[MainViewModel::class.java]
        val notificationData = viewModel.getNotificationList()
        notificationAdapter.setNotificationItem(notificationData)
        return binding.root
    }
}