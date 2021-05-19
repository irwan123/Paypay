package com.cloudless.paypay.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.CarouselFragmentBinding

class CarouselFragment: Fragment() {
    private lateinit var binding: CarouselFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private var img = intArrayOf(
            R.drawable.undraw_business_shop_qw5t,
            R.drawable.undraw_mobile_photos_psm5,
            R.drawable.undraw_mail_2_tqip,
            R.drawable.undraw_successful_purchase_uyin
    )
    var text = arrayOf(
            "Merchant",
            "Foto Produk",
            "Transaksi Berhasil",
            "Belanja Senang",
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = CarouselFragmentBinding.inflate(layoutInflater, container, false)
        binding.caraouselView.pageCount = text.size
        binding.caraouselView.setImageListener { position, imageView ->
            imageView.setImageResource(img[position])
        }
        binding.caraouselView.setImageClickListener { position ->
            Toast.makeText(context, text[position], Toast.LENGTH_SHORT).show()
        }
        binding.btMasuk.setOnClickListener {
            fr = LoginFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        binding.btDaftar.setOnClickListener {
            fr = CreateFragment()
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