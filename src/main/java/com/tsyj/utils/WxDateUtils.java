package com.tsyj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @description: 微信日期
 * @author: guos
 * @date: 2018/6/25
 */
public class WxDateUtils {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static long oneDay = 86400000L;//一天的毫秒数

    public WxDateUtils() {
    }


    /**
     * 获取 Calendar对象
     *
     * @return
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    // 提供“yyyy-mm-dd”形式的字符串到毫秒的转换
    public static long getMillis(String dateString) {
        String[] date = dateString.split("-");
        return getMillis(date[0], date[1], date[2]);

    }

    // 根据输入的年、月、日，转换成毫秒表示的时间
    public static long getMillis(int year, int month, int day) {
        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, day);
        return calendar.getTimeInMillis();

    }

    // 根据输入的年、月、日，转换成毫秒表示的时间
    public static long getMillis(String yearString, String monthString, String dayString) {
        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString) - 1;
        int day = Integer.parseInt(dayString);
        return getMillis(year, month, day);

    }

    // 获得当前时间的毫秒表示
    public static long getNow() {
        return System.currentTimeMillis();

    }

    // 根据输入的毫秒数，获得日期字符串
    public static String getDate(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取格式化时间
     *
     * @param date
     * @return
     */
    public static String getTime(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(calendar.getTime());
    }

    // 根据输入的毫秒数，获得年份
    public static int getYear(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.YEAR);

    }

    // 根据输入的毫秒数，获得月份
    public static int getMonth(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MONTH);

    }

    // 根据输入的毫秒数，获得日期
    public static int getDay(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.DATE);

    }

    // 根据输入的毫秒数，获得小时
    public static int getHour(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.HOUR_OF_DAY);

    }

    // 根据输入的毫秒数，获得分钟
    public static int getMinute(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MINUTE);

    }

    // 根据输入的毫秒数，获得秒
    public static int getSecond(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.SECOND);

    }

    // 获取指定毫秒数的对应星期
    public static String getWeek(long millis) {
        Calendar calendar = getCalendar();
        calendar.setTimeInMillis(millis);
        String week = "";
        int cweek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (cweek) {
            case 1:
                week = "日";
                break;
            case 2:
                week = "一";
                break;
            case 3:
                week = "二";
                break;
            case 4:
                week = "三";
                break;
            case 5:
                week = "四";
                break;
            case 6:
                week = "五";
                break;
            case 7:
                week = "六";
                break;
        }
        return week;

    }

    // 获得今天日期
    public static String getTodayData() {
        return getDate(getNow());

    }

    // 获得明天日期
    public static String getTomoData() {
        // 86400000为一天的毫秒数
        return getDate(getNow() + oneDay);

    }

    // 获得后天日期
    public static String getTheDayData() {
        return getDate(getNow() + oneDay + oneDay);
    }

    // 获得昨天日期
    public static String getYesData() {
        return getDate(getNow() - oneDay);
    }

    // 获得前天日期
    public static String getBeforeYesData() {
        return getDate(getNow() - oneDay - oneDay);
    }

    /**
     * 获取今天时间具体内容
     *
     * @return
     */
    public static String StringData() {
        final Calendar c = getCalendar();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "天";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        return mYear + "年" + mMonth + "月" + mDay + "日" + " 星期" + mWay;
    }

    /**
     * 获取类似今天、昨天的简单名称
     *
     * @param date 格式为 20xx-xx-xx
     * @return
     */
    public static String getCustomStr(String date) {
        if (getMillis(date) == getMillis(getBeforeYesData())) {
            return "前天 ";
        } else if (getMillis(date) == getMillis(getYesData())) {
            return "昨天 ";
        } else if (getMillis(date) == getMillis(getTodayData())) {
            return "今天 ";
        } else if (getMillis(date) == getMillis(getTomoData())) {
            return "明天 ";
        } else if (getMillis(date) == getMillis(getTheDayData())) {
            return "后天 ";
        } else {
            return "星期" + getWeek((getMillis(date))) + " ";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getBeforeYesData());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2018-06-01 10:30:25");
        System.out.println(getCustomStr(WxDateUtils.sdf.format(date)) + getTime(date));
    }
}