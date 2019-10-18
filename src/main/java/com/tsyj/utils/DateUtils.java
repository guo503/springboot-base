package com.tsyj.utils;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
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

    public static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        System.out.println(getDayOfWeekWithinDateInterval("2019-10-18","2019-10-28",0));
    }


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
     *
     * @param kind 指定参数
     * @return Date 指定类型的Date
     */
    public static Date getFormatDate(Date date, int kind) {
        String currentDateStr = formatDate(date, kind);
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


    /**
     * 根据日期获取当天是周几
     *
     * @param datetime 日期
     * @return 周几
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = sdf.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }


    /**
     * 根据日期获取当天是周几
     * 0周日 1周一 2周二 3周三 4周四 5周五 6周六
     *
     * @param date 日期
     * @return 周几
     */
    public static int dateToWeek(Date date) {
        int[] weekDays = {0, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(getFormatDate(date, 0));
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }


    /**
     * 根据时间间隔，算出后面的时间。例如，24时，分成3部分，每个时间间隔是8小时
     * 然后，初始时间加上8小时，得到新的时间，新的时间再加上8小时，得到另一个时间，依此类推
     *
     * @param totalHours 计算的总小时数
     * @param part       将总小时分成的分数
     * @param initTime   初始时间
     * @return 计算后的时间列表
     */
    public static List<LocalDateTime> getGapTime(int totalHours, int part, LocalDateTime initTime) {
        if (totalHours == 0) totalHours = 24;
        if (part == 0) part = 1;
        if (initTime == null) initTime = LocalDateTime.now();
        long gap = totalHours / part;
        List<LocalDateTime> timeList = Lists.newArrayList();
        for (int i = 0; i < part; i++) {
            long newGap = gap * i;
            LocalDateTime newTime = initTime.plusHours(newGap);
            timeList.add(newTime);
        }
        return timeList;
    }


    /**
     * 根据天数获取第几周的第几天
     *
     * @param startDate 时间参考基数
     * @return 第3周-4
     */
    public static String getWeekAndDays(LocalDate startDate, LocalDate endDate) {
        //时间段内天数
        Long between = endDate.toEpochDay() - startDate.toEpochDay();
        between++;
        int weeks = (int) (Math.ceil(between * 1.0 / 7));
        long days = between.intValue() % 7 == 0 ? 7 : between % 7;
        return new StringBuffer("第").append(weeks).append("周").append("-").append(days).toString();
    }


    /**
     * 获取某段时间内的周一（二等等）的日期
     *
     * @param dataBegin 开始日期
     * @param dataEnd   结束日期
     * @param weekDays  获取周几，1－6代表周一到周六。0代表周日
     * @return 返回日期List
     */
    public static List<Date> getDayOfWeekWithinDateInterval(String dataBegin, String dataEnd, int weekDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return getDateList(sdf.parse(dataBegin), sdf.parse(dataEnd), weekDays);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式转化异常");
        }
    }


    /**
     * 获取某段时间内的周一（二等等）的日期
     *
     * @param dataBegin 开始日期
     * @param dataEnd   结束日期
     * @param weekDays  获取周几，1－6代表周一到周六。0代表周日
     * @return 返回日期List
     */
    public static List<Date> getDayOfWeekWithinDateInterval(Date dataBegin, Date dataEnd, int weekDays) {
        return getDateList(dataBegin, dataEnd, weekDays);
    }


    private static List<Date> getDateList(Date dataBegin, Date dataEnd, int weekDays) {
        Date[] dates = {dataBegin, dataEnd};
        List<Date> dateResult = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; ) {
            cal.setTime(date);
            if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
                //yyyy-MM-dd
                dateResult.add(getFormatDate(date, 0));
            }
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();
        }
        return dateResult;
    }
}
