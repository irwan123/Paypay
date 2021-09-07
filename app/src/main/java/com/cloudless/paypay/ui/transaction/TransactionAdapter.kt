package com.cloudless.paypay.ui.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.databinding.HistoryItemsBinding

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    private val historyList = ArrayList<TransactionModel>()

    fun setData(transactionList: List<TransactionModel>){
        if (transactionList == null) return
        historyList.clear()
        historyList.addAll(transactionList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = HistoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val data = historyList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = historyList.size

    inner class TransactionViewHolder(private val binding: HistoryItemsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TransactionModel){

        }
    }
}