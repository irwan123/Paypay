package com.cloudless.paypay.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.PromoBanner
import com.cloudless.paypay.data.model.PromoItem
import com.cloudless.paypay.databinding.FragmentHomeBinding
import com.cloudless.paypay.ui.cart.CartActivity
import com.cloudless.paypay.ui.main.MainViewModel
import com.cloudless.paypay.ui.payment.PaymentActivity
import com.cloudless.paypay.viewmodel.ViewModelFactory
import com.synnapps.carouselview.ImageListener


class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val image = ArrayList<PromoBanner>()
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
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), factory)[MainViewModel::class.java]
            viewModel.getMerchantPromo().observe(viewLifecycleOwner, ::setPromoMerchant)
            viewModel.getPromoBanner().observe(viewLifecycleOwner, ::setBanner)
        }
        fragmentHomeBinding.cartBtn.setOnClickListener {
            val intent = Intent(activity, PaymentActivity::class.java)
            startActivity(intent)
        }
        val carouselView = fragmentHomeBinding.carouselView
        carouselView.pageCount = image.size
        val imageListener =
            ImageListener { position, imageView ->
                Glide.with(requireContext())
                    .load(image[position].image_url)
                    .into(imageView)
            }
        carouselView.setImageListener(imageListener)
        return fragmentHomeBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding.cartBtn.setOnClickListener {
            val intent = Intent(context, CartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setPromoMerchant(result: List<PromoItem>){
        promoAdapter.setPromo(result)
        promoAdapter.notifyDataSetChanged()
    }

    private fun setBanner(result: List<PromoBanner>){
        image.addAll(result)
    }
}