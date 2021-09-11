package com.cloudless.paypay.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudless.paypay.data.source.repository.DataRepository
import com.cloudless.paypay.di.Injection
import com.cloudless.paypay.ui.addproduct.AddProductViewModel
import com.cloudless.paypay.ui.cart.CartViewModel
import com.cloudless.paypay.ui.login.LoginViewModel
import com.cloudless.paypay.ui.main.MainViewModel
import com.cloudless.paypay.ui.merchant.MerchantViewModel
import com.cloudless.paypay.ui.payment.PaymentViewModel
import com.cloudless.paypay.ui.transaction.TransactionViewModel

class ViewModelFactory private constructor(private val dataRepository: DataRepository)
    : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(MerchantViewModel::class.java) -> {
                MerchantViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(AddProductViewModel::class.java) -> {
                AddProductViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(PaymentViewModel::class.java) -> {
                PaymentViewModel(dataRepository) as T
            }
            modelClass.isAssignableFrom(TransactionViewModel::class.java) -> {
                TransactionViewModel(dataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}