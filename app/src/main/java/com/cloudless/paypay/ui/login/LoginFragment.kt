package com.cloudless.paypay.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.LoginModel
import com.cloudless.paypay.data.model.UserModel
import com.cloudless.paypay.data.source.local.Preference
import com.cloudless.paypay.databinding.LoginFragmentBinding
import com.cloudless.paypay.ui.dialog.ProgressDialog
import com.cloudless.paypay.ui.main.MainActivity
import com.cloudless.paypay.viewmodel.ViewModelFactory

class LoginFragment : Fragment() {
    private lateinit var binding: LoginFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    private lateinit var loading: ProgressDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        binding.tvForgot.setOnClickListener {
            fr = ForgotFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        binding.tvDaftar.setOnClickListener {
            fr = CreateFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        binding.toolbar.setNavigationOnClickListener {
            fr = CarouselFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loading = ProgressDialog(requireActivity())
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(requireActivity(), factory)[LoginViewModel::class.java]
        binding.btMasuk.setOnClickListener {
            loading.startLoadingDialog()
            val userName = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            val loginModel = LoginModel(userName, password)
            viewModel.login(loginModel).observe(viewLifecycleOwner, ::resultLogin)
        }
    }

    private fun resultLogin(result: UserModel){
        val preference = Preference(requireContext())
        preference.userId = result.id.oid
        preference.balance = result.balance.toString()
        preference.isLoggedIn = true
        loading.dismiss()
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}