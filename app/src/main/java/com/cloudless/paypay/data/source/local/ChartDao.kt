package com.cloudless.paypay.data.source.local

import androidx.room.*
import com.cloudless.paypay.data.model.ChartModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChartDao {
    @Query("Select * from " + ChartModel.TABLE_NAME)
    fun getProductList(): Flow<List<ChartModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: ChartModel?)

    @Delete
    suspend fun delete(product: ChartModel?)
}