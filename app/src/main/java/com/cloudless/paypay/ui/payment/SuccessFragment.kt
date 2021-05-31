package com.cloudless.paypay.ui.payment

import android.content.Intent
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
import com.cloudless.paypay.ui.main.MainActivity

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
        val middleAnimation = AnimationUtils.loadAnimation(context, R.anim.middle_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(context, R.anim.bottom_animation)
        binding.imgSuccess.startAnimation(middleAnimation)
        binding.tvSuccess.startAnimation(bottomAnimation)
        binding.btKembali.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}