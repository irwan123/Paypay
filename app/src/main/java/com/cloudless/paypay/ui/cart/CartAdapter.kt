package com.cloudless.paypay.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.CartListItemBinding

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val listCartItem = ArrayList<ChartModel>()

    fun setCartItem(data: List<ChartModel>?){
        if (data == null) return
        this.listCartItem.clear()
        this.listCartItem.addAll(data)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = listCartItem[position]
        holder.bind(cartItem)
    }

    override fun getItemCount(): Int = listCartItem.size

    inner class CartViewHolder(private val binding: CartListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(chartModel: ChartModel){
            Glide.with(itemView.context)
                    .load(chartModel.imageProduct)
                    .into(binding.imgItemProduct)
            binding.tvProductName.text = chartModel.productName
            binding.tvPriceProduct.text = chartModel.price.toString()
            binding.tvAmountProduct.text = chartModel.amount.toString()
        }
    }
}