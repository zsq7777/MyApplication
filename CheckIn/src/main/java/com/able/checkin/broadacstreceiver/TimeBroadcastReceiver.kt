package com.able.checkin.broadacstreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.time.LocalTime

/**
 * Create by 赵思琦 on 2022/3/22
 * email zsqandzyr@gmail.com
 */
class TimeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_TIME_TICK) {
            val now = LocalTime.now()
            Log.i("时间变化", "${now.hour}:${now.minute}:${now.second}")
        }
    }
}