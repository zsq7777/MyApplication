package com.able.checkin.entity

import java.util.*

/**
 * 打卡时间规则
 */
data class CheckInTimeRuleEntity(
    //标题
    val title: String,
    //开始时间
    val startTime: Date,
    //结束时间
    val endTime: Date,
    //当日已执行
    val isRun: Boolean
)