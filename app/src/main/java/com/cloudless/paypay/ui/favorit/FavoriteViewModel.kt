package com.cloudless.paypay.ui.favorit

import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.FavoriteModel
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData

class FavoriteViewModel(private val repository: DataRepository): ViewModel() {
    fun getFavoriteList(): List<FavoriteModel> = DummyData.generateFavoriteDummy()
}