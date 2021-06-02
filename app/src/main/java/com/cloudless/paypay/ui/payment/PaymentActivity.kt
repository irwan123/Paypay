package com.cloudless.paypay.ui.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.ActivityPaymentBinding
import com.cloudless.paypay.ui.main.MainActivity

class PaymentActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CHECKOUT: String = "extra_checkout"
    }
    private lateinit var binding : ActivityPaymentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listItem = intent.getParcelableArrayListExtra<ChartModel>(EXTRA_CHECKOUT) as ArrayList<ChartModel>
        addPay(listItem)
    }
    private fun addPay(listItem: ArrayList<ChartModel>){
        fr = PayFragment()
        val bundle = Bundle()
        bundle.putParcelableArrayList(EXTRA_CHECKOUT, listItem)
        fr.arguments = bundle
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