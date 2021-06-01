package com.cloudless.paypay.ui.addproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.ProductModel
import com.cloudless.paypay.data.source.repository.DataRepository

class AddProductViewModel(private val repository: DataRepository): ViewModel() {

    fun getProduct(identifier: String, merchantId: String): LiveData<ProductModel> = repository.getProduct(identifier, merchantId)
    fun setProcut(productModel: ProductModel){

    }
}