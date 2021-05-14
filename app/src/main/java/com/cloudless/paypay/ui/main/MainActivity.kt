package com.cloudless.paypay.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).isEnabled = false
    }
}