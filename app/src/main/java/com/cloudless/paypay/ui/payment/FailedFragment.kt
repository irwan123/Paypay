package com.cloudless.paypay.ui.payment

import android.content.Intent
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
import com.cloudless.paypay.ui.main.MainActivity

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
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}