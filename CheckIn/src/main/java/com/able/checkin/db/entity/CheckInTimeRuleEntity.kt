package com.able.checkin.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * 打卡时间规则
 */
@Entity(tableName = "time_rule")
data class CheckInTimeRuleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    //标题
    @ColumnInfo(name = "c_title") val title: String,
    //开始时间
    @ColumnInfo(name = "start_time") val startTime: Long,
    //结束时间
    @ColumnInfo(name = "end_time") val endTime: Long,
    //当日已执行
    @ColumnInfo(name = "is_run") val isRun: Boolean

)