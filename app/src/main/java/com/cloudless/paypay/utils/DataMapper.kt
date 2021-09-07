package com.cloudless.paypay.utils

import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.model.TransactionModel
import com.cloudless.paypay.data.model.userId
import com.cloudless.paypay.data.source.local.entity.ChartEntity
import com.cloudless.paypay.data.source.local.entity.TransactionEntity

object DataMapper {
    fun ModelToEntity (input: ChartModel) = ChartEntity(
        id = input.id,
        merchantId = input.merchantId,
        productName = input.productName,
        imageProduct = input.imageProduct,
        price = input.price,
        amount = input.amount,
        totalPrice = input.totalPrice
    )
    fun ListEntityToModel(input: List<ChartEntity>): List<ChartModel> {
        val list = ArrayList<ChartModel>()
        input.map {
            val cart = ChartModel(
                id = it.id,
                merchantId = it.merchantId,
                productName = it.productName,
                imageProduct = it.imageProduct,
                price = it.price,
                amount = it.amount,
                totalPrice = it.totalPrice
            )
            list.add(cart)
        }
        return list
    }
    fun ListHistoryToEntity(input: List<TransactionModel>): List<TransactionEntity>{
        val list = ArrayList<TransactionEntity>()
        input.map{
            val history = TransactionEntity(
                userId = it.userId,
                merchantId = it.merchantId,
                product = it.product,
                imageProduct = it.imageProduct,
                amount = it.amount,
                price = it.price,
                totalPrice = it.totalPrice,
                status = it.status
            )
            list.add(history)
        }
        return list
    }

    fun listEntityHistoryToModel(input: List<TransactionEntity>): List<TransactionModel>{
        val list = ArrayList<TransactionModel>()
        input.map{
            val history = TransactionModel(
                id = it.id,
                userId = it.userId,
                merchantId = it.merchantId,
                product = it.product,
                imageProduct = it.imageProduct,
                amount = it.amount,
                price = it.price,
                totalPrice = it.totalPrice,
                status = it.status
            )
            list.add(history)
        }
        return list
    }
}