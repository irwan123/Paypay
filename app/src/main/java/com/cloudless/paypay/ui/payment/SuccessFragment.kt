package com.cloudless.paypay.ui.payment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.SuccessFragmentBinding
import com.cloudless.paypay.ui.main.MainActivity
import com.cloudless.paypay.ui.transaction.TransactionActivity

class SuccessFragment: Fragment() {
    private lateinit var binding: SuccessFragmentBinding
    private val paymentAdapter = PaymentItemAdapter()
    private var listItem = ArrayList<ChartModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SuccessFragmentBinding.inflate(layoutInflater, container, false)
        val middleAnimation = AnimationUtils.loadAnimation(context, R.anim.middle_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(context, R.anim.bottom_animation)
        binding.imgSuccess.startAnimation(middleAnimation)
        binding.tvSuccess.startAnimation(bottomAnimation)
        binding.btKembali.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        if (arguments != null){
            if (listItem.isEmpty()) {
                listItem = arguments?.getParcelableArrayList<ChartModel>(PaymentActivity.EXTRA_CHECKOUT) as ArrayList<ChartModel>
            } else {
                listItem.clear()
                listItem = arguments?.getParcelableArrayList<ChartModel>(PaymentActivity.EXTRA_CHECKOUT) as ArrayList<ChartModel>
            }
        }
        binding.rvProdukList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = paymentAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paymentAdapter.setItem(listItem)
    }
}