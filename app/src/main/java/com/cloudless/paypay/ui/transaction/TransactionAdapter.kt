package com.cloudless.paypay.ui.transaction

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
            Glide.with(itemView.context)
                .load(data.imageProduct)
                .into(binding.imgProduct)
            binding.tvProductName.text = data.product
            binding.tvAmountProduct.text = data.amount.toString()
            binding.tvStatus.text = data.status
            if (data.status == "Sukses") {
                binding.tvStatus.setTextColor(Color.GREEN)
            } else {
                binding.tvStatus.setTextColor(Color.RED)
            }
            binding.tvTotalPrice.text = data.totalPrice.toString()
        }
    }
}