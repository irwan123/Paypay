package com.cloudless.paypay.ui.payment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.FailedFragmentBinding
import com.cloudless.paypay.ui.main.MainActivity

class FailedFragment: Fragment() {
    private lateinit var binding: FailedFragmentBinding
    private val paymentAdapter = PaymentItemAdapter()
    private var listItem = ArrayList<ChartModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FailedFragmentBinding.inflate(layoutInflater, container, false)
        binding.btKembali.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        if (listItem.isEmpty()) {
            listItem = arguments?.getParcelableArrayList<ChartModel>(PaymentActivity.EXTRA_CHECKOUT) as ArrayList<ChartModel>
        } else {
            listItem.clear()
            listItem = arguments?.getParcelableArrayList<ChartModel>(PaymentActivity.EXTRA_CHECKOUT) as ArrayList<ChartModel>
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