package com.able.checkin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.able.checkin.util.WakeLockUtil

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        WakeLockUtil.acquireWakeLock(this)
    }
}