package com.cloudless.paypay.ui.addproduct

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ActivityAddProductBinding
import com.cloudless.paypay.ui.main.MainActivity

class AddProductActivity : AppCompatActivity() {

    companion object{
        const val MERCHANT_ID: String = "merchant_id"
    }
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val merchantId = intent.getStringExtra(MERCHANT_ID)
        addFragmentAddProduck(merchantId?:"null")
    }
    private fun addFragmentAddProduck(merchantId: String){
        fr = AddProductFragment(merchantId)
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.frame_add_product, fr)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@AddProductActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}