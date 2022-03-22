package com.able.checkin


import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.able.checkin.broadacstreceiver.TimeBroadcastReceiver
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(TimeBroadcastReceiver(), filter);
    }
}

const val PREFERENCES_FILENAME = "passive_data_prefs"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCES_FILENAME)
