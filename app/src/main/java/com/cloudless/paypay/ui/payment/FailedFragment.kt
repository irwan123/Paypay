package com.cloudless.paypay.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.FailedFragmentBinding
import com.cloudless.paypay.ui.home.HomeFragment

class FailedFragment: Fragment() {
    private lateinit var binding: FailedFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FailedFragmentBinding.inflate(layoutInflater, container, false)
        binding.btKembali.setOnClickListener {
            fr = HomeFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        binding.toolbar.setNavigationOnClickListener {
            fr = HomeFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        return binding.root
    }
}