package com.tsyj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Description
 * @Author: guoshuai
 * @Date: create in 2018-01-03 16:22
 */
public class DateUtils {
    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日 HH:mm");

    /**
     * 日期格式化成字符串
     *
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        if (null == date) {
            return null;
        }
        String dateStr = sdf2.format(date);
        if (dateStr.startsWith("0")) {
            return dateStr.substring(1);
        }
        return dateStr;
    }

    /**
     * 获取指定时间的那天23:59:59的时间
     *
     * @param date
     * @param flag
     * @return
     */
    public static Date convertDayToDetail(final Date date, String flag) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if ("s".equals(flag)) {
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
        } else {
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
        }
        //c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }


    /**
     * 获取下一天
     *
     * @param date
     * @return
     */
    public static Date getNextDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }


    /**
     * 倒计时
     *
     * @param start 开始时间
     * @param min   倒计时间（分钟）
     */
    public static void countDown(long start, int min) {
        //结束时间
        final long end = start + min * 60 * 1000;

        final Timer timer = new Timer();
        //延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("倒计时");
            }
        }, 0, 1000);
        //计时结束时候，停止全部timer计时计划任务
        timer.schedule(new TimerTask() {
            public void run() {
                timer.cancel();
            }

        }, new Date(end));
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return date;
    }


    /**
     * 返回指定天数的日期
     *
     * @param date
     * @param day
     * @param format
     * @return
     */
    public static String getOnlyDate(Date date, int day, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(cal.getTime());
    }


    /**
     * 返回指定天数的日期
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getExpireDate(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    public static void main(String[] args) {
        //System.out.println(getCurrentTime());
        // System.out.println(getOnlyDate(new Date(), 15, "yyyy-MM-dd HH:mm:ss"));

        //logger.error("信息出错，id:{}",12);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(sdf.format(getExpireDate(new Date(),-7)));


        LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 1, 0, 0);
        LocalDateTime ldt2 = LocalDateTime.now();
        System.out.println(localDateTime2Date(ldt1).before(localDateTime2Date(ldt2)));
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     */
    public static void date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        System.out.println(localDateTime.toString());//2018-03-27T14:07:32.668
        System.out.println(localDateTime.toLocalDate() + " " + localDateTime.toLocalTime());//2018-03-27 14:48:57.453

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//This class is immutable and thread-safe.@since 1.8
        System.out.println(dateTimeFormatter.format(localDateTime));//2018-03-27 14:52:57
    }


    /**
     * 根据指定参数kind，获取指定类型的Date日期(年月日)
     * @param kind 指定参数
     * @return Date 指定类型的Date
     */
    public static Date getFormatDate(Date date, int kind) {
        String currentDateStr = formatDate( date , kind);
        return toDate(currentDateStr, kind);
    }

    /**
     * 根据kind输出string格式
     *
     * @param date
     * @param kind
     * @return
     */
    public static String formatDate(Date date, int kind) {
        SimpleDateFormat sdf = new SimpleDateFormat(getDateFormat(kind));
        return sdf.format(date);
    }

    private static String getDateFormat(int kind) {
        String[] format = {"yyyy-MM-dd", // 0
                "yyyy-MM-dd HH:mm:ss", // 1
                "yyyy",// 2
                "M",// 3
                "dd", // 4
                "yyyy年M月d日H点m分", // 5
                "yyyy年M月d日", // 6
                "H点m分", // 7
                "yyyy/MM/dd HH:mm", // 8
                "HH",// 9
                "mm",// 10
                "yyyyMMdd", // 11
                "yyyyMMddHHmmss", // 12
                "yyyy-MM-dd 23:59:59", // 13
                "HH:mm:ss", // 14
                "yyyy/MM/dd HH:mm:ss", // 15
                "yyyy/MM/dd HH:mm",//16
                "HHmmss",//17,
                "HH:mm:ss", //18
                "mmss", //19
                "HH:mm", //20
                "yyyy-MM-dd HH:mm" //21
        };
        return format[kind];
    }

    public static Date toDate(String dateText, int kind) {
        String format = getDateFormat(kind);
        if (dateText == null) {
            return null;
        }
        DateFormat df = null;
        try {
            if (format == null) {
                df = new SimpleDateFormat();
            } else {
                df = new SimpleDateFormat(format);
            }
            df.setLenient(false);
            return df.parse(dateText);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 判断是否达到指定的连续天数
     *
     * @param dates        ：指定日期数组
     * @param continueDays ：连续天数
     * @return
     * @author guos
     * @date 2019/7/18 9:38
     **/
    public static boolean checkContinueDays(List<Date> dates, int continueDays) {
        boolean isContinue = false;
        int days = 1;
        if (CollectionUtils.isEmpty(dates)) {
            return days >= continueDays;
        }
        List<Date> dateList = new ArrayList<>();
        for (Date date : dates) {
            //yyyy-MM-dd
            dateList.add(DateUtils.getFormatDate(date, 0));
        }
        int size = dateList.size();
        for (int i = size - 1; i > 0; i--) {
            if ((dateList.get(i).getTime() - dateList.get(i - 1).getTime()) / (1000 * 60 * 60 * 24) == 1) {
                days++;
                //已连续天数大于等于指定要达到的天数
                if (days >= continueDays) {
                    isContinue = true;
                }
            } else {
                days = 1;
            }
        }
        return isContinue;
    }


}
