package com.able.checkin.datasource

import java.time.Instant

//Instant 时间戳 Duration 时间段
data class CheckInEntity(
    var workTime: Instant,
    var workRealTime: Instant?,
    var tvGoOffWorkTime: Instant,
    var tvGoOffWorkRealTime: Instant?
)
