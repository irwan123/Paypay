package com.cloudless.paypay.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_history", indices = arrayOf(Index("transactionId", unique = true)))
class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "transactionId")
    var transactionId: String,
    @ColumnInfo(name = "userId")
    var userId: String = "",
    @ColumnInfo(name = "merchantId")
    var merchantId: String,
    @ColumnInfo(name = "product")
    var product: String,
    @ColumnInfo(name = "image_product")
    var imageProduct: String,
    @ColumnInfo(name = "amount")
    var amount: Int = 0,
    @ColumnInfo(name = "price")
    var price: Int = 0,
    @ColumnInfo(name = "totalPrice")
    var totalPrice: Int = 0,
    @ColumnInfo(name = "status")
    var status: String
)