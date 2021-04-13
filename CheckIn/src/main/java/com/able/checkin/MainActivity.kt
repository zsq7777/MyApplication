package com.able.checkin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.able.checkin.workmanager.CheckInWorkManager
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
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

    private fun initView() {
        //增加打卡时间规则
        findViewById<Button>(R.id.btn1).setOnClickListener {

        }
        //是否开启大小周  , 本周是大周还是小周。
        findViewById<SwitchMaterial>(R.id.btn2).setOnClickListener {

        }
        //是否开启自动打卡
        findViewById<SwitchMaterial>(R.id.btn3).setOnClickListener {

        }
    }

}