package com.cloudless.paypay.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.source.local.Preference
import com.cloudless.paypay.databinding.PayFragmentBinding
import com.cloudless.paypay.ui.cart.CartAdapter
import com.cloudless.paypay.ui.payment.PaymentActivity.Companion.EXTRA_CHECKOUT
import com.cloudless.paypay.utils.DataMapper

class PayFragment: Fragment() {
    private lateinit var binding: PayFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private var listItem = ArrayList<ChartModel>()
    private var total: Int = 0
    private var saldo: Int = 0
    private val checkoutAdapter = CheckoutAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PayFragmentBinding.inflate(layoutInflater, container, false)

        if (arguments != null){
            listItem = arguments?.getParcelableArrayList<ChartModel>(EXTRA_CHECKOUT) as ArrayList<ChartModel>
        }

        binding.rvItem.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = checkoutAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkoutAdapter.setData(listItem)
        setCheckout(listItem)
        if (saldo > total){
            binding.btBayar.setOnClickListener {
                uploadTransaction(listItem, "Sukses")
                fr = SuccessFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList(EXTRA_CHECKOUT, listItem)
                fr.arguments = bundle
                fm = parentFragmentManager
                fm.beginTransaction().apply {
                    replace(R.id.frameLayout_payment, fr)
                    addToBackStack(null)
                    commit()
                }
            }
        } else {
            binding.btBayar.setOnClickListener {
                uploadTransaction(listItem, "Gagal")
                fr = FailedFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList(EXTRA_CHECKOUT, listItem)
                fr.arguments = bundle
                fm = parentFragmentManager
                fm.beginTransaction().apply {
                    replace(R.id.frameLayout_payment, fr)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }

    private fun setCheckout(result: ArrayList<ChartModel>){
        val preference = Preference(requireContext())
        saldo = Integer.parseInt(preference.balance!!)
        total = result.sumBy{it.totalPrice}
        val amount = result.sumBy { it.amount }
        binding.tvAmount.text = amount.toString()
        binding.tvTotal.text = total.toString()
    }

    private fun uploadTransaction(listItem: List<ChartModel>, status: String){
        val preference = Preference(requireContext())
        val id = preference.userId!!
        val listData = DataMapper.listChartToHistory(listItem, id, status)
        val viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory()).get(PaymentViewModel::class.java)
        viewModel.clearChart()
        viewModel.uploadTransaction(listData)
    }
}