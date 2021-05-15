package com.cloudless.paypay.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.FragmentHomeBinding
import com.synnapps.carouselview.ImageListener


class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val image = arrayOf<Int>(
        R.drawable.promo_banner1,
        R.drawable.promo_banner2,
        R.drawable.promo_banner3
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val carouselView = fragmentHomeBinding.carouselView
        carouselView.pageCount = image.size

        val imageListener =
            ImageListener { position, imageView ->
                imageView.setImageResource(
                    image[position]
                )
            }
        carouselView.setImageListener(imageListener)
    }
}