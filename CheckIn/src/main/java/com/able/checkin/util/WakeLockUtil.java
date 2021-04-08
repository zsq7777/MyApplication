package com.able.checkin.util;

import android.content.Context;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WakeLockUtil {
    @Nullable
    public static PowerManager.WakeLock acquireWakeLock(@NonNull Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (pm == null)
            return null;
        PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |
                        PowerManager.FULL_WAKE_LOCK |
                        PowerManager.ON_AFTER_RELEASE,
                context.getClass().getName());
        wakeLock.acquire();
        return wakeLock;
    }

    public static void release(@Nullable PowerManager.WakeLock wakeLock) {
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
    }

}
