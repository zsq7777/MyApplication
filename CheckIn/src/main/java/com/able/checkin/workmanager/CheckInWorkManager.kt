package com.able.checkin.workmanager

import android.app.AlertDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Log
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.able.checkin.util.WakeLockUtil

class CheckInWorkManager(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    private val mContext: Context = context

    override fun doWork(): Result {
        //亮屏 解锁 打卡
        //亮屏
//        WakeLockUtil.acquireWakeLock(mContext)
        Log.i("worker日志","开启亮屏")
        //打开钉钉
        openDingDing()
        //工作成功
        return Result.success()
    }

    private fun openDingDing() {
        val packageManager = mContext.packageManager
        val pi: PackageInfo?
        val packageName = "com.alibaba.android.rimet"
        pi = packageManager.getPackageInfo(packageName, 0)
        val resolveIntent = Intent(Intent.ACTION_MAIN, null)
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        resolveIntent.setPackage(pi.packageName)
        val apps =
            packageManager.queryIntentActivities(resolveIntent, 0)
        val resolveInfo = apps.iterator().next()
        if (resolveInfo != null) {
            val className = resolveInfo.activityInfo.name
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val cn = ComponentName(packageName, className)
            intent.component = cn
            mContext.startActivity(intent)
        }
    }

}