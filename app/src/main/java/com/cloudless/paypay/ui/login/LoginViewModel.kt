package com.cloudless.paypay.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.LoginModel
import com.cloudless.paypay.data.source.repository.DataRepository

class LoginViewModel(private val repository: DataRepository): ViewModel() {

    fun login(loginModel: LoginModel): LiveData<String> = repository.login(loginModel)
}