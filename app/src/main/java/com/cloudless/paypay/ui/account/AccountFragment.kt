package com.cloudless.paypay.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.UserModel
import com.cloudless.paypay.data.source.local.Preference
import com.cloudless.paypay.databinding.FragmentAccountBinding
import com.cloudless.paypay.ui.main.MainViewModel
import com.cloudless.paypay.viewmodel.ViewModelFactory


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)

        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(requireActivity(), factory)[MainViewModel::class.java]
        val preference = Preference(requireContext())
        val userId = preference.userId
        viewModel.getDetailUser(userId.toString()).observe(viewLifecycleOwner, ::setDetail)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.check -> Toast.makeText(context, "Simpan Data", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun setDetail(userModel: UserModel){
        binding.tvMainUsername.text = userModel.name
        binding.tvEmailMain.text = userModel.email
    }
}