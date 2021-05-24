package com.cloudless.paypay.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.data.model.MerchantPromoModel
import com.cloudless.paypay.databinding.MerchantPromoItemBinding

class MerchantPromoAdapter: RecyclerView.Adapter<MerchantPromoAdapter.MerchantPromoViewHolder>() {
    private val listPromo = ArrayList<MerchantPromoModel>()

    fun setPromo(data: List<MerchantPromoModel>?){
        if (data == null) return
        this.listPromo.clear()
        this.listPromo.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchantPromoViewHolder {
        val binding = MerchantPromoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MerchantPromoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MerchantPromoViewHolder, position: Int) {
        val promo = listPromo[position]
        holder.bind(promo)
    }

    override fun getItemCount(): Int = listPromo.size

    inner class MerchantPromoViewHolder(private val binding: MerchantPromoItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(merchantPromoModel: MerchantPromoModel) {
            binding.tvMerchantName.text = merchantPromoModel.merchantName
            binding.tvProductName.text = merchantPromoModel.productName
            Glide.with(itemView.context)
                .load(merchantPromoModel.imageProduct)
                .into(binding.imgProduct)
            binding.tvPriceBefore.text = merchantPromoModel.price.toString()
            binding.tvPriceAfter.text = " - "+merchantPromoModel.pricePromo.toString()
        }
    }
}