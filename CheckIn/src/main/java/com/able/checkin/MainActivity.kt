package com.able.checkin

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.PowerManager
import android.provider.Settings
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
        initView();
        initData()






//        val checkInWorkRequest =
//            PeriodicWorkRequestBuilder<CheckInWorkManager>(15, TimeUnit.MINUTES)
//                .build()
//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//            "checkIn",
//            ExistingPeriodicWorkPolicy.REPLACE, checkInWorkRequest
//        )


    }

    private fun initView() {
        findViewById<Button>(R.id.BtnDingDing).setOnClickListener {
            val intent = Intent()
            val cn = ComponentName(
                "com.alibaba.android.rimet",
                "com.alibaba.android.rimet.biz.LaunchHomeActivity"
            )
            intent.component = cn
            startActivity(intent)
        }

//        home_app_item-菜单
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

    /**
     * 开启电量优化
     */
    private fun ignoreBatteryOptimization(activity: Activity){
       val powerManager = getSystemService(POWER_SERVICE) as PowerManager
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           val hasIgnored =
               powerManager.isIgnoringBatteryOptimizations(activity.packageName);
           if(!hasIgnored){
               val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)
               intent.data = Uri.parse("package:"+activity.packageName)
               startActivity(intent)
           }
       }
   }




}