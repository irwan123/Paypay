package com.cloudless.paypay.ui.addproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.model.ProductModel
import com.cloudless.paypay.data.source.repository.DataRepository
import kotlinx.coroutines.launch

class AddProductViewModel(private val repository: DataRepository): ViewModel() {

    fun getProduct(identifier: String, merchantId: String): LiveData<ProductModel> = repository.getProduct(identifier, merchantId)
    fun addToChart(chartModel: ChartModel) = viewModelScope.launch { repository.insert(chartModel) }
}