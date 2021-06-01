package com.cloudless.paypay.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.databinding.CartListItemBinding

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val listCartItem = ArrayList<ChartModel>()
    private lateinit var onDeleteProduct: OnDeleteProduct

    fun setCartItem(data: List<ChartModel>?){
        if (data == null) return
        this.listCartItem.clear()
        this.listCartItem.addAll(data)
    }

    fun setOnDeleteItemListener(onDeleteItem: OnDeleteProduct){
        this.onDeleteProduct = onDeleteItem
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
            var price: Int
            Glide.with(itemView.context)
                    .load(chartModel.imageProduct)
                    .into(binding.imgItemProduct)
            binding.tvProductName.text = chartModel.productName
            binding.tvPriceProduct.text = chartModel.price.toString()
            binding.tvAmountProduct.text = chartModel.amount.toString()

            binding.btnAdd.setOnClickListener {
                chartModel.amount += 1
                price = chartModel.price
                binding.tvAmountProduct.text = chartModel.amount.toString()
                binding.tvPriceProduct.text = (price * chartModel.amount).toString()
                notifyDataSetChanged()
            }

            if (chartModel.amount == 0) {
                binding.btnSubstract.visibility = View.GONE
            } else {
                binding.btnSubstract.visibility = View.VISIBLE
                binding.btnSubstract.setOnClickListener {
                    chartModel.amount -= 1
                    price = chartModel.price
                    binding.tvAmountProduct.text = chartModel.amount.toString()
                    binding.tvPriceProduct.text = (price * chartModel.amount).toString()
                    notifyDataSetChanged()
                }
            }

            binding.btnDelete.setOnClickListener { onDeleteProduct.onDeleteItem(chartModel) }
        }
    }

    interface OnDeleteProduct{
        fun onDeleteItem(chartModel: ChartModel)
    }
}