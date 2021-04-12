package com.able.checkin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.able.checkin.workmanager.CheckInWorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //使用构建器
//        val checkInWorkRequest = PeriodicWorkRequestBuilder<CheckInWorkManager>(2, TimeUnit.MINUTES)
//            .build()

        // Additional configuration

        val checkInWorkRequest =
            PeriodicWorkRequestBuilder<CheckInWorkManager>(15, TimeUnit.MINUTES)
                .build()

        //一次性任务
//        val checkInWorkRequest = OneTimeWorkRequest.from(CheckInWorkManager::class.java)

//        WorkManager.getInstance(this).enqueue(checkInWorkRequest)
        //唯一工作
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("checkIn",
            ExistingPeriodicWorkPolicy.REPLACE,checkInWorkRequest)

    }

}