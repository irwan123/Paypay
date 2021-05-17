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
    private lateinit var ft: FragmentTransaction
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = ForgotFragmentBinding.inflate(layoutInflater, container, false)
        binding.toolbar.setNavigationOnClickListener {
            fr = CarouselFragment()
            fm = fragmentManager!!
            ft = fm.beginTransaction()
            ft.replace(R.id.frameLayout, fr)
            ft.addToBackStack(null)
            ft.commit()
        }
        binding.tvMasuk.setOnClickListener {
            fr = LoginFragment()
            fm = fragmentManager!!
            ft = fm.beginTransaction()
            ft.replace(R.id.frameLayout, fr)
            ft.addToBackStack(null)
            ft.commit()
        }
        return binding.root
    }
}