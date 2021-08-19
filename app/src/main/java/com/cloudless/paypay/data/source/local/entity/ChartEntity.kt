package com.cloudless.paypay.data.source.local.entity

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cloudless.paypay.data.source.local.entity.ChartEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class ChartEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = COLUMN_MERCHANT_ID)
    var merchantId: String? = "",
    @ColumnInfo(name = COLUMN_PRODUCT_NAME)
    var productName: String? = "",
    @ColumnInfo(name = COLUMN_IMAGE_URL)
    var imageProduct: String? = "",
    @ColumnInfo(name = COLUMN_PRICE)
    var price: Int,
    @ColumnInfo(name = COLUMN_AMOUNT)
    var amount: Int,
    @ColumnInfo(name = COLUMN_TOTAL_PRICE)
    var totalPrice: Int
){
    companion object {
        const val TABLE_NAME = "chart"
        private const val COLUMN_ID = BaseColumns._ID
        private const val COLUMN_MERCHANT_ID = "merchant_id"
        private const val COLUMN_PRODUCT_NAME = "produk_name"
        private const val COLUMN_IMAGE_URL = "image_url"
        private const val COLUMN_PRICE = "price"
        private const val COLUMN_AMOUNT = "amount"
        private const val COLUMN_TOTAL_PRICE = "total_price"
    }
}