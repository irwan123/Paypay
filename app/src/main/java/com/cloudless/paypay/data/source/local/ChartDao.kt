package com.cloudless.paypay.data.source.local

import androidx.room.*
import com.cloudless.paypay.data.source.local.entity.ChartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChartDao {
    @Query("Select * from " + ChartEntity.TABLE_NAME)
    fun getProductList(): Flow<List<ChartEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: ChartEntity)

    @Delete
    fun delete(product: ChartEntity)

    //@Query("UPDATE chart SET amount = :amount ,total_price= :totalPrice WHERE _id LIKE :id ")
    @Update
    fun update(prduct: ChartEntity)
}