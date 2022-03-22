package com.able.checkin.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Create by 赵思琦 on 2022/3/22
 * email zsqandzyr@gmail.com
 */
class CheckInRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    val workTime: Flow<String> = dataStore.data.map { prefs ->
        prefs[WORK_TIME] ?: "8:45"
    }

    suspend fun storeWorkTime(workTime: String) {
        dataStore.edit { prefs ->
            prefs[WORK_TIME] = workTime;
        }
    }

    val workRealTime: Flow<String?> = dataStore.data.map { prefs ->
        prefs[WORK_REAL_TIME]
    }

    suspend fun storeWorkRealTime(workRealTime: String) {
        dataStore.edit { prefs ->
            prefs[WORK_REAL_TIME] = workRealTime;
        }
    }

    val goOffWorkTime: Flow<String> = dataStore.data.map { prefs ->
        prefs[GO_OFF_WORK_TIME] ?: "18:00"
    }

    suspend fun storeGoOffWorkTime(goOffWorkTime: String) {
        dataStore.edit { prefs ->
            prefs[GO_OFF_WORK_TIME] = goOffWorkTime
        }
    }

    val goOffWorkRealTime: Flow<String?> = dataStore.data.map { prefs ->
        prefs[GO_OFF_WORK_REAL_TIME]
    }

    suspend fun storeGoOffWorkRealTime(goOffWorkRealTime: String) {
        dataStore.edit { prefs ->
            prefs[GO_OFF_WORK_REAL_TIME] = goOffWorkRealTime
        }
    }

    val isFastCheckIn: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[IS_FAST_CHECK_IN] ?: false
    }

    suspend fun storeIsFastCheckIn(isFastCheckIn: Boolean) {
        dataStore.edit { prefs ->
            prefs[IS_FAST_CHECK_IN] = isFastCheckIn
        }
    }

    companion object {
        private val WORK_TIME = stringPreferencesKey("workTime")
        private val WORK_REAL_TIME = stringPreferencesKey("workRealTime")
        private val GO_OFF_WORK_TIME = stringPreferencesKey("goOffWorkTime")
        private val GO_OFF_WORK_REAL_TIME = stringPreferencesKey("goOffWorkRealTime")
        private val IS_FAST_CHECK_IN = booleanPreferencesKey("isFastCheckIn")
    }

}