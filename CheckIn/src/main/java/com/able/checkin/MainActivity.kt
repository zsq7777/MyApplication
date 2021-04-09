package com.able.checkin

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = 14
        calendar[Calendar.MINUTE] = 40
        calendar[Calendar.SECOND] = 0
        Log.i("值","${calendar.timeInMillis}")
        val pendingIntent:PendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent().setClass(this, MainActivity2::class.java),
            0
        )
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        alarmManager?.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent)


    }

}