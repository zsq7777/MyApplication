package com.able.checkin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.able.checkin.db.dao.CheckInTimeRuleDao
import com.able.checkin.db.entity.CheckInTimeRuleEntity

@Database(entities = [CheckInTimeRuleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun checkInTimeRuleDao(): CheckInTimeRuleDao
    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "CheckIn.db")
                .build()
    }

}