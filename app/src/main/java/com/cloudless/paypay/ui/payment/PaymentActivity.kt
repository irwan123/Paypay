package com.cloudless.paypay.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ActivityPaymentBinding
import com.cloudless.paypay.ui.main.MainActivity

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPaymentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addPay()
    }
    fun addPay(){
        fr = PayFragment()
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout_payment, fr)
        ft.addToBackStack(null)
        ft.commit()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@PaymentActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}