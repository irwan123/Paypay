package com.cloudless.paypay.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.SuccessFragmentBinding
import com.cloudless.paypay.ui.home.HomeFragment

class SuccessFragment: Fragment() {
    private lateinit var binding: SuccessFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SuccessFragmentBinding.inflate(layoutInflater, container, false)
        val topAnimation = AnimationUtils.loadAnimation(context, R.anim.top_animation)
        val middleAnimation = AnimationUtils.loadAnimation(context, R.anim.middle_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(context, R.anim.bottom_animation)
        binding.imgSuccess.startAnimation(middleAnimation)
        binding.tvSuccess.startAnimation(bottomAnimation)
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