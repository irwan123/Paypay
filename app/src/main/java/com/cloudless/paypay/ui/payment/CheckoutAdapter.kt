package com.cloudless.paypay.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.CheckoutListItemBinding

class CheckoutAdapter: RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>() {
    private var listCart = ArrayList<ChartModel>()

    fun setData(data: List<ChartModel>){
        listCart.clear()
        listCart.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        val binding = CheckoutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CheckoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        val data = listCart[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listCart.size

    inner class CheckoutViewHolder(private val binding: CheckoutListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ChartModel){
            Glide.with(itemView.context)
                .load(data.imageProduct)
                .into(binding.imgItemProduct)
            binding.tvProductName.text = data.productName
            binding.tvPriceProduct.text = data.price.toString()
            binding.tvAmountProduct.text = data.amount.toString()
        }
    }
}