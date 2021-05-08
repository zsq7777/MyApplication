package com.able.checkin.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {
    public static boolean isRunTime(String startTime, String endTime) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            Date startDate = sf.parse(startTime);
            Date endDate = sf.parse(endTime);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            Calendar endCalenar = Calendar.getInstance();
            endCalenar.setTime(endDate);

            if (startCalendar.getTimeInMillis() > endCalenar.getTimeInMillis()) { //跨天了
                endCalenar.add(Calendar.DAY_OF_MONTH, 1);
            }

            return isRunTime(startCalendar, endCalenar);
        } catch (ParseException e) {
            Log.e("时间", "解析时间出错"+e.getMessage());
            return false;
        }  catch (Exception e) {
            Log.e("时间", "解析出现异常"+e.getMessage());
            return false;
        }
    }

    public static boolean isRunTime(String startTime, int duration) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            Date startDate = sf.parse(startTime);
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);

            Calendar endCalenar = Calendar.getInstance();
            endCalenar.setTime(startCalendar.getTime());
            endCalenar.add(Calendar.SECOND, duration);

            return isRunTime(startCalendar, endCalenar);
        } catch (ParseException e) {
            return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * @param startCal
     * @param endCal
     * @return
     */
    public static boolean isRunTime(Calendar startCal, Calendar endCal) {
        Calendar nowCal = Calendar.getInstance();
        nowCal.setTime(new Date());
        startCal.set(nowCal.get(Calendar.YEAR), nowCal.get(Calendar.MONTH), nowCal.get(Calendar.DAY_OF_MONTH));
        endCal.set(nowCal.get(Calendar.YEAR), nowCal.get(Calendar.MONTH), nowCal.get(Calendar.DAY_OF_MONTH));
        if (endCal.get(Calendar.DAY_OF_MONTH) > startCal.get(Calendar.DAY_OF_MONTH)) {
            endCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        if (nowCal.getTimeInMillis() > startCal.getTimeInMillis() && nowCal.getTimeInMillis() < endCal.getTimeInMillis()){
            return true;
        }
        else {
            return false;
        }
    }
}
