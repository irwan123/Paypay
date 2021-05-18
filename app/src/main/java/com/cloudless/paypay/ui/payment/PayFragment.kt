package com.cloudless.paypay.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.PayFragmentBinding

class PayFragment: Fragment() {
    private lateinit var binding: PayFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    private var boolean: Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PayFragmentBinding.inflate(layoutInflater, container, false)
        if (boolean == true){
            binding.btBayar.setOnClickListener {
                fr = SuccessFragment()
                fm = parentFragmentManager
                fm.beginTransaction().apply {
                    replace(R.id.frameLayout, fr)
                    addToBackStack(null)
                    commit()
                }
            }
        } else {
            binding.btBayar.setOnClickListener {
                fr = FailedFragment()
                fm = parentFragmentManager
                fm.beginTransaction().apply {
                    replace(R.id.frameLayout, fr)
                    addToBackStack(null)
                    commit()
                }
            }
        }
        return binding.root
    }
}