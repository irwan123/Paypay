package com.cloudless.paypay.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ForgotFragmentBinding

class ForgotFragment: Fragment() {
    private lateinit var binding: ForgotFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ForgotFragmentBinding.inflate(layoutInflater, container, false)
        binding.toolbar.setNavigationOnClickListener {
            fr = CarouselFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        binding.tvMasuk.setOnClickListener {
            fr = LoginFragment()
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