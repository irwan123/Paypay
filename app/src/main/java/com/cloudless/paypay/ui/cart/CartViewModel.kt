package com.cloudless.paypay.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.utils.DummyData
import kotlinx.coroutines.launch

class CartViewModel(private val repository: DataRepository): ViewModel() {
    fun getCartList(): LiveData<List<ChartModel>> = repository.getAllProduct().asLiveData()
    fun delete(chartModel: ChartModel) = viewModelScope.launch { repository.delete(chartModel) }
    fun update(id: Int, amount: Int, totalPrice: Int) = viewModelScope.launch { repository.update(id, amount, totalPrice) }
}