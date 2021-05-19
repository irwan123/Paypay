package com.cloudless.paypay.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.FragmentHomeBinding
import com.cloudless.paypay.ui.main.MainViewModel
import com.cloudless.paypay.ui.payment.PaymentActivity
import com.synnapps.carouselview.ImageListener


class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val image = arrayOf(
        R.drawable.promo_banner1,
        R.drawable.promo_banner2,
        R.drawable.promo_banner3
    )
    private val promoAdapter = MerchantPromoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        fragmentHomeBinding.rvMerchantPromo.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = promoAdapter
        }
        val carouselView = fragmentHomeBinding.carouselView
        carouselView.pageCount = image.size
        val imageListener =
            ImageListener { position, imageView ->
                imageView.setImageResource(
                    image[position]
                )
            }
        carouselView.setImageListener(imageListener)
        fragmentHomeBinding.cartBtn.setOnClickListener {
            val intent = Intent(activity, PaymentActivity::class.java)
            startActivity(intent)
        }
        return fragmentHomeBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
            val promoData = viewModel.getPromo()
            promoAdapter.setPromo(promoData)
        }
    }
}