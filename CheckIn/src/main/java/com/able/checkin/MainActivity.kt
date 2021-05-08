package com.able.checkin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.able.checkin.db.AppDatabase
import com.able.checkin.db.entity.CheckInTimeRuleEntity
import com.able.checkin.workmanager.CheckInWorkManager
import com.google.android.material.switchmaterial.SwitchMaterial
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity() : AppCompatActivity() {
    private val mCompositeDisposable= CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()

        val checkInWorkRequest =
            PeriodicWorkRequestBuilder<CheckInWorkManager>(15, TimeUnit.MINUTES)
                .build()
//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//            "checkIn",
//            ExistingPeriodicWorkPolicy.REPLACE, checkInWorkRequest
//        )
        WorkManager
            .getInstance(this)
            .enqueue(checkInWorkRequest)


    }

    private fun initData() {
        val checkInTimeRuleDao = AppDatabase.getInstance(applicationContext).checkInTimeRuleDao()
        val loadCheckInTimeRule: Flowable<Array<CheckInTimeRuleEntity>> = checkInTimeRuleDao.loadCheckInTimeRule()
        //查询所有规则
        mCompositeDisposable.add(loadCheckInTimeRule.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

            })



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

    override fun onStop() {
        super.onStop()

    }

}