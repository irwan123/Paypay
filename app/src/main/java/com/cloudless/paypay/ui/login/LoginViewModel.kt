package com.cloudless.paypay.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cloudless.paypay.data.model.LoginModel
import com.cloudless.paypay.data.model.RegisterModel
import com.cloudless.paypay.data.model.UserModel
import com.cloudless.paypay.data.source.repository.DataRepository

class LoginViewModel(private val repository: DataRepository): ViewModel() {

    fun login(loginModel: LoginModel): LiveData<UserModel> = repository.login(loginModel)

    fun register(registerModel: RegisterModel): LiveData<String> = repository.register(registerModel)
}