package com.cloudless.paypay.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Index
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cloudless.paypay.data.source.local.entity.ChartEntity
import com.cloudless.paypay.data.source.local.entity.TransactionEntity

@Database(entities = [ChartEntity::class, TransactionEntity::class],exportSchema = false, version = 1)
abstract class ChartDatabase: RoomDatabase() {
    abstract fun chartDao(): ChartDao

    companion object {
        @Volatile
        private var INSTANCE: ChartDatabase? = null
        fun getDatabase(
            context: Context
        ): ChartDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChartDatabase::class.java,
                    "chart_database"
                )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}