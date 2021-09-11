package com.cloudless.paypay.ui.transaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudless.paypay.R
import com.cloudless.paypay.data.source.local.Preference
import com.cloudless.paypay.databinding.ActivityTransactionBinding
import com.cloudless.paypay.viewmodel.ViewModelFactory

class TransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionBinding
    private val historyAdapter = TransactionAdapter()
    private lateinit var viewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(TransactionViewModel::class.java)
        initHistory()
        with(binding.rvTransHistory){
            layoutManager = LinearLayoutManager(this@TransactionActivity)
            setHasFixedSize(false)
            adapter = historyAdapter
        }
        viewModel.getHistory().observe(this,{ data ->
            if (data != null) {
                historyAdapter.setData(data)
            } else {
                binding.tvNothing.visibility = View.VISIBLE
            }
        })
    }

    private fun initHistory(){
        val pref = Preference(this)
        val id = pref.userId
        if (id != null) {
            viewModel.getHistoryFromNet(id.toString()).observe(this,{
                if (it != null) {
                    viewModel.insertHistory(it)
                }
            })
        }
    }
}