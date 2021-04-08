package com.able.checkin.broadacstreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver :BroadcastReceiver(){
    /**
     * 一旦从此方法返回代码，便会认为该组件不再活跃
     * 在接收器的 onReceive() 方法中调用 goAsync()，并将 BroadcastReceiver.PendingResult 传递给后台线程。
     * 这样，在从 onReceive() 返回后，广播仍可保持活跃状态。不过，即使采用这种方法，系统仍希望您非常快速地完成广播（在 10 秒以内）。
     * 为避免影响主线程，它允许您将工作移到另一个线程。
     */
    override fun onReceive(context: Context, intent: Intent) {
        //此处应在子线程执行
    }


}