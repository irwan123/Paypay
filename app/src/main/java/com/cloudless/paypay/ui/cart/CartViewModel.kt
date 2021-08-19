package com.cloudless.paypay.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.source.repository.DataRepository
import kotlinx.coroutines.launch

class CartViewModel(private val repository: DataRepository): ViewModel() {
    fun getCartList(): LiveData<List<ChartModel>> = repository.getAllProduct().asLiveData()
    fun delete(chartModel: ChartModel) = repository.delete(chartModel)
    fun update(chartModel: ChartModel) =  repository.update(chartModel)
}