package com.cloudless.paypay.ui.merchant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.data.model.MerchantModel
import com.cloudless.paypay.databinding.MerchantListItemBinding

class MerchantAdapter: RecyclerView.Adapter<MerchantAdapter.MerchantViewHolder>() {
    private val listMerchant = ArrayList<MerchantModel>()

    fun setMerchant(data: List<MerchantModel>?){
        if (data == null) return
        this.listMerchant.clear()
        this.listMerchant.addAll(data)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchantViewHolder {
        val binding = MerchantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MerchantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MerchantViewHolder, position: Int) {
        val merchant = listMerchant[position]
        holder.bind(merchant)
    }

    override fun getItemCount(): Int = listMerchant.size

    inner class MerchantViewHolder(private val binding: MerchantListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(merchantModel: MerchantModel){
            Glide.with(itemView.context)
                    .load(merchantModel.merchantPhoto)
                    .into(binding.imgMerchantLogo)
            binding.tvMerchantName.text = merchantModel.merchantName
            binding.tvMerchantLocation.text = merchantModel.location
        }
    }
}