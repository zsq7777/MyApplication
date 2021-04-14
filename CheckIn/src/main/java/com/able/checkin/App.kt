package com.able.checkin

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.able.checkin.db.AppDatabase
import com.able.checkin.db.dao.CheckInTimeRuleDao

class App: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}