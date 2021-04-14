package com.able.checkin.db.dao

import androidx.room.*
import com.able.checkin.db.entity.CheckInTimeRuleEntity
import io.reactivex.Flowable

@Dao
interface CheckInTimeRuleDao {
    /**
     * 查询所有规则
     */
    @Query("SELECT * FROM time_rule ")
    fun loadCheckInTimeRule(): Flowable<Array<CheckInTimeRuleEntity>>
    /**
     * 增加 ，返回插入的行ID
     */
    @Insert
    fun insertTimeRule(checkInTimeRuleEntity: CheckInTimeRuleEntity):Long
    /**
     * 更新 ,返回更新的行数
     */
    @Update
    fun updateTimeRule(checkInTimeRuleEntity: CheckInTimeRuleEntity):Int
    /**
     * 删除，返回删除的行数
     */
    @Delete
    fun deleteTieRule(checkInTimeRuleEntity: CheckInTimeRuleEntity):Int



}