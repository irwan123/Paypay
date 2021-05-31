package com.cloudless.paypay.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.R
import com.cloudless.paypay.data.model.MerchantPromoModel
import com.cloudless.paypay.data.model.PromoItem
import com.cloudless.paypay.databinding.MerchantPromoItemBinding

class MerchantPromoAdapter: RecyclerView.Adapter<MerchantPromoAdapter.MerchantPromoViewHolder>() {
    private val listPromo = ArrayList<PromoItem>()

    fun setPromo(data: List<PromoItem>?){
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
        fun bind(promoItem: PromoItem) {
            binding.tvMerchantName.text = promoItem.merchantName
            binding.tvProductName.text = promoItem.name
            binding.tvPriceBefore.text = promoItem.price.toString()
            binding.tvPriceAfter.text = " - "+promoItem.promoPrice

            if (!promoItem.imageProduct.isNullOrEmpty()) {
                Glide.with(itemView.context)
                        .load(promoItem.imageProduct)
                        .into(binding.imgProduct)
            } else {
                Glide.with(itemView.context)
                        .load(R.drawable.broken_image)
                        .into(binding.imgProduct)
            }
        }
    }
}