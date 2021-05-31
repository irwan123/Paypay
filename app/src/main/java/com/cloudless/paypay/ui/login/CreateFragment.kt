package com.cloudless.paypay.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.LoginModel
import com.cloudless.paypay.data.model.RegisterModel
import com.cloudless.paypay.databinding.CreateFragmentBinding
import com.cloudless.paypay.ui.main.MainActivity
import com.cloudless.paypay.viewmodel.ViewModelFactory

class CreateFragment : Fragment() {
    private lateinit var binding: CreateFragmentBinding
    private lateinit var fr: Fragment
    private lateinit var fm: FragmentManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = CreateFragmentBinding.inflate(layoutInflater, container, false)
        binding.toolbar.setNavigationOnClickListener {
            fr = CarouselFragment()
            fm = parentFragmentManager
            fm.beginTransaction().apply {
                replace(R.id.frameLayout, fr)
                addToBackStack(null)
                commit()
            }
        }
        binding.tvMasuk.setOnClickListener {
            fr = LoginFragment()
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

        binding.btDaftar.setOnClickListener {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), factory)[LoginViewModel::class.java]
            val userName = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val register = RegisterModel(userName, email, password)
            viewModel.register(register).observe(viewLifecycleOwner, ::resultRegister)
        }
    }

    private fun resultRegister(result: String){
        Log.d("result register", result)
        if (result == "User added successfully") {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
            Log.d("result login", result)
        }
    }
}