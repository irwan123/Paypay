package com.cloudless.paypay.ui.favorit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.databinding.FragmentFavoritBinding
import com.cloudless.paypay.viewmodel.ViewModelFactory


class FavoritFragment : Fragment() {
    private lateinit var binding: FragmentFavoritBinding
    private val favoriteAdapter = FavoriteAdapter()
    private lateinit var favoriteViewModel : FavoriteViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoritBinding.inflate(layoutInflater, container, false)
        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = favoriteAdapter
        }
        val factory = ViewModelFactory.getInstance(requireContext())
        favoriteViewModel = ViewModelProvider(requireActivity(), factory)[FavoriteViewModel::class.java]
        val favoriteData = favoriteViewModel.getFavoriteList()
        favoriteAdapter.setFavoriteItem(favoriteData)
        return binding.root
    }
}