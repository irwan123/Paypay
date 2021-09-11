package com.cloudless.paypay.data.source.local

import androidx.room.*
import com.cloudless.paypay.data.source.local.entity.ChartEntity
import com.cloudless.paypay.data.source.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChartDao {
    @Query("Select * from " + ChartEntity.TABLE_NAME)
    fun getProductList(): Flow<List<ChartEntity>>

    @Query("Select * FROM transaction_history")
    fun getHistory(): Flow<List<TransactionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(listTransaction: List<TransactionEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: ChartEntity)

    @Delete
    fun delete(product: ChartEntity)

    @Query("DELETE FROM " + ChartEntity.TABLE_NAME)
    suspend fun clearChart()

    //@Query("UPDATE chart SET amount = :amount ,total_price= :totalPrice WHERE _id LIKE :id ")
    @Update
    fun update(prduct: ChartEntity)
}