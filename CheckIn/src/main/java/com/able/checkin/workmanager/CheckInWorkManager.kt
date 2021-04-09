package com.able.checkin.workmanager

import android.content.Context
import androidx.annotation.NonNull
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.able.checkin.util.WakeLockUtil

class CheckInWorkManager(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    private val mContext: Context = context

    override fun doWork(): Result {
        //亮屏 解锁 打卡
        //亮屏
        WakeLockUtil.acquireWakeLock(mContext)
        //工作成功
        return Result.success()
    }

}