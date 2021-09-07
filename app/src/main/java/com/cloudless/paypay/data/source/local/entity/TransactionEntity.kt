package com.cloudless.paypay.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_history")
class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "userId")
    var userId: String,
    @ColumnInfo(name = "merchantId")
    var merchantId: String,
    @ColumnInfo(name = "product")
    var product: String,
    @ColumnInfo(name = "amount")
    var amount: Int = 0,
    @ColumnInfo(name = "price")
    var price: Int = 0,
    @ColumnInfo(name = "totalPrice")
    var totalPrice: Int = 0,
    @ColumnInfo(name = "status")
    var status: String
)