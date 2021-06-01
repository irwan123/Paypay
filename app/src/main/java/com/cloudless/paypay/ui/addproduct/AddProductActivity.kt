package com.cloudless.paypay.ui.addproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.MerchantListModel
import com.cloudless.paypay.databinding.ActivityAddProductBinding
import com.cloudless.paypay.ui.login.CarouselFragment

class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragmentAddProduck()
    }
    private fun addFragmentAddProduck(){
        fr = AddProductFragment()
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        ft.replace(R.id.frame_add_product, fr)
        ft.addToBackStack(null)
        ft.commit()
    }
}