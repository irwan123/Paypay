package com.cloudless.paypay.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.model.FavoriteModel
import com.cloudless.paypay.data.model.ProductModel
import com.cloudless.paypay.databinding.ItemCheckoutBinding

class PaymentItemAdapter: RecyclerView.Adapter<PaymentItemAdapter.PaymentViewHolder>() {
    private val listItem = ArrayList<ChartModel>()
    fun setItem(data: ArrayList<ChartModel>?){
        if (data == null) return
        this.listItem.clear()
        this.listItem.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = ItemCheckoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listItem.size

    inner class PaymentViewHolder(private val binding: ItemCheckoutBinding)
        :RecyclerView.ViewHolder(binding.root) {
            fun bind(item: ChartModel){
                binding.itemName.text = item.productName
                binding.itemPrice.text = item.totalPrice.toString()
            }
    }
}