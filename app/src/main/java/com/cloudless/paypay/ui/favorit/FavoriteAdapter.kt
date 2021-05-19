package com.cloudless.paypay.ui.favorit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cloudless.paypay.data.FavoriteModel
import com.cloudless.paypay.databinding.FavoriteListItemBinding

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    private val listFavoriteItem = ArrayList<FavoriteModel>()
    fun setFavoriteItem(data: List<FavoriteModel>?){
        if (data == null) return
        this.listFavoriteItem.clear()
        this.listFavoriteItem.addAll(data)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = FavoriteListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoiteItem = listFavoriteItem[position]
        holder.bind(favoiteItem)
    }
    override fun getItemCount(): Int = listFavoriteItem.size

    inner class FavoriteViewHolder(private val binding: FavoriteListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind (favoriteModel: FavoriteModel){
            Glide.with(itemView.context)
                    .load(favoriteModel.imageProduct)
                    .into(binding.imgItemProduct)
            binding.tvProductName.text = favoriteModel.productName
            binding.tvPriceProduct.text = favoriteModel.price.toString()
        }
    }

}