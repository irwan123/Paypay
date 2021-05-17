package com.cloudless.paypay.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ActivityLoginMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginMainBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addCaraousel()
    }
    fun addCaraousel(){
        fr = CarouselFragment()
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, fr)
        ft.addToBackStack(null)
        ft.commit()
    }
}