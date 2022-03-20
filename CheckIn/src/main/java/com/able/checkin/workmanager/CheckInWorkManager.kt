package com.able.checkin.workmanager

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.able.checkin.util.TimeUtils
import com.able.checkin.util.WakeLockUtil
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CheckInWorkManager(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    private val mContext: Context = context
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)

    override fun doWork(): Result {

//        val cal = Calendar.getInstance()
//         if (cal[Calendar.DAY_OF_WEEK] == Calendar.SATURDAY || cal[Calendar.DAY_OF_WEEK] == Calendar.SUNDAY) {
//             return Result.success()
//         }

//        if(TimeUtils.isRunTime("2021-05-08 8:25:00","2021-05-08 8:50:59")||TimeUtils.isRunTime("2021-05-08 18:40:00","2021-05-08 18:59:59")
//            ||TimeUtils.isRunTime("2021-05-08 12:50","2021-05-08 13:14:59")){

//        if (TimeUtils.isRunTime(
//                "2021-05-08 13:39:00",
//                "2021-05-08 13:59:59"
//            ) || TimeUtils.isRunTime("2021-05-08 18:15:00", "2021-05-08 18:35:59") ) {
            //亮屏 解锁 打卡
            //亮屏
            WakeLockUtil.acquireWakeLock(mContext)
            Log.i("worker日志", "开启亮屏")
            //打开应用
            openDingDing()
//            Log.i("时间log", "在时间范围内--当前时间：${dateFormat.format(Date())}")
//        } else {
//            Log.i("时间log", "不在时间范围内--当前时间：${dateFormat.format(Date())}")
//        }


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