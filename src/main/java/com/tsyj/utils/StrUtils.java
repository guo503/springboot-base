package com.tsyj.utils;

import org.springframework.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

/**
 * @Description
 * @Author: guos
 * @Date: create in 2018-01-23 13:52
 */
public class StrUtils {

    private final static String phone_ddl_lock = "UserAgtService_phone_ddl_%s";

    /**
     * 生成uuid
     *
     * @return
     */
    public static String uuid() {
        String str = UUID.randomUUID().toString();
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18)
                + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }


    /**
     * 根据表示拼接字符串
     *
     * @param str
     * @param split
     * @return
     */
    public static String concatStr(String[] str, String split) {
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isEmpty(str) || str.length == 0) {
            return null;
        }
        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                sb.append(getStr(str[i]));
            } else {
                sb.append(getStr(str[i]) + split);
            }
        }
        return sb.toString();
    }


    /**
     * 字符串去空格
     *
     * @param str
     * @return
     */
    public static String getStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return str.trim();
    }


    /**
     * 获取字符串长度
     *
     * @param str
     * @return
     */
    public static int getLength(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        return str.trim().length();
    }


    /**
     * 生成模糊查询字符串
     *
     * @param str
     * @return
     */
    public static String getBlurStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return "%" + getStr(str) + "%";
    }


    /**
     * 拼接字符串
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    public static String getBlurStr(String str, String left, String right) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        return left + getStr(str) + right;
    }


    /**
     * 校验是对象是否全是大写
     *
     * @param str
     * @return
     */
    public static boolean isUpper(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getStr(str).matches("^[A-Z]+$");
    }


    /**
     * 校验是对象是否全是小写
     *
     * @param str
     * @return
     */
    public static boolean isLower(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getStr(str).matches("^[a-z]+$");
    }

    /**
     * 校验是对象是否全是汉字
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getStr(str).matches("^[\u4e00-\u9fa5]+$");
    }


    /**
     * 校验是对象是否全是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getStr(str).matches("^[0-9]+$");
    }

    /**
     * 校验是对象的长度是否和要求的相等
     *
     * @param str
     * @return
     */
    public static boolean checkLength(String str, int len1, int len2) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getLength(str) == len1 || getLength(str) == len2;
    }

    /**
     * 校验是对象的价格格式
     *
     * @param str
     * @return
     */
    public static boolean checkPrice(String str, int len1, int len2) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        String newStr = getStr(str);
        try {
            if (newStr.contains(".")) {
                int left = newStr.substring(0, newStr.indexOf(".")).length();
                int right = newStr.substring(newStr.indexOf(".") + 1).length();
                return left <= len1 && right <= len2;
            } else {
                return getLength(newStr) <= len1;
            }
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 判断输入值是否超过规定长度
     *
     * @param str
     * @param len
     * @return
     */
    public static boolean isOverranging(String str, int len) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return getLength(str) > len;
    }


    /**
     * 校验字母数字组合
     *
     * @param str
     * @param a      :字母位数
     * @param b：数字位数
     * @return
     */
    public static boolean checkGroup(String str, int a, int b) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        String newStr = getStr(str);
        if (newStr.length() != a + b) {
            return false;
        }
        try {
            String left = newStr.substring(0, a);
            String right = newStr.substring(a);
            //System.out.println("left=" + left + " right=" + right);
            return left.length() == a && right.length() == b && left.matches("^[a-zA-Z]+$") && right.matches("^[0-9]+$");
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 校验费率
     *
     * @param str
     * @return
     */
    public static boolean checkRadio(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        String newStr = getStr(str);
        try {
            double res = Double.parseDouble(newStr);
            return res >= 0.0001 && res <= 99;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 校验长度，大写或数字
     *
     * @param str
     * @param len
     * @return
     */
    public static boolean checkLenAndUpperAndNumber(String str, int len) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }

        return getLength(str) == len && (isUpper(str) || isNumber(str));
    }


    /**
     * 隐藏手机号
     *
     * @param phone
     * @return
     */
    public static String getHidePhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }


    public static String getObject(String url, boolean isQuery) throws MalformedURLException {
        String object = null;
        URL uri = new URL(url);
        String path = uri.getPath();
        String query = uri.getQuery();
        if (path != null) {
            if (isQuery && query != null) {
                object = path.substring(1) + "?" + query;
            } else {
                object = path.substring(1);
            }
        }
        return object;
    }


    /**
     * length表示生成字符串的长度
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int number;
        for (int i = 0; i < length; i++) {
            number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成指定length的随机字符串（A-Z，a-z，0-9）
     * 排除L,i,0,o,l
     *
     * @param length
     * @author: guos
     * @date: 2019/3/15 9:36
     * @return:
     **/
    public static String getRandomStr(int length) {
        String str = "abcdefghjklmnpqrstuvwxyzABCDEFGHIJKMNOPQRSTUVWXYZ23456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



    /**
     * 获取绘本封面图片名字
     *
     * @param url
     * @return
     */
    public static String picName(String url) {
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        return url.substring(url.lastIndexOf('/') + 1, url.lastIndexOf('.'));
    }


    public static void main(String[] args) {

        //System.out.println(picName("https://pdabc-dev.oss-cn-hangzhou.aliyuncs.com/huiben/L1_001_Farm_Animals_01.jpg"));

        System.out.println(getRandomStr(10));
    }
}
