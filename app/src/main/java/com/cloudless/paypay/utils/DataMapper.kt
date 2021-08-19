package com.cloudless.paypay.utils

import com.cloudless.paypay.data.model.ChartModel
import com.cloudless.paypay.data.source.local.entity.ChartEntity

object DataMapper {
    fun ModelToEntity (input: ChartModel) = ChartEntity(
        merchantId = input.merchantId,
        productName = input.productName,
        imageProduct = input.imageProduct,
        price = input.price,
        amount = input.amount,
        totalPrice = input.totalPrice
    )

    fun EntityToModel(input: ChartEntity) = ChartModel(
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
}