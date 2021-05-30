package com.cloudless.paypay.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ActivityLoginMainBinding
import com.cloudless.paypay.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginMainBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addCaraousel()

        val factory = ViewModelFactory.getInstance(this)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]


    }
    private fun addCaraousel(){
        fr = CarouselFragment()
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, fr)
        ft.addToBackStack(null)
        ft.commit()
    }
}