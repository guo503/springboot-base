package com.tsyj.utils;


/**
 *异常捕获工具类
 * @author: guos
 * @date: 2019/4/12 16:11
 **/
public class ExceptionUtils {

    /**
     * 获取异常明细
     *
     * @param cause
     * @return
     */
    public static String getExceptionMsg(Throwable cause) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n").append(cause.toString()).append("\n");
        for (int i = 0; i < cause.getStackTrace().length; i++) {
            buffer.append("    ").append(cause.getStackTrace()[i].toString()).append("\n");
        }
        return buffer.toString();
    }
}
