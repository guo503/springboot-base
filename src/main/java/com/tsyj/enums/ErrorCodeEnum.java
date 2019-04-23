package com.tsyj.enums;

/**
 * api请求错误码
 *
 * @author caiLinFeng
 * @date 2018年2月2日
 */
public enum ErrorCodeEnum {
    OK(0, "success"),
    UNDEFINE_ERROR(101, "未定义的错误"),
    ACCESS_TOKEN_ERROR(102, "accessToken错误"),
    ACCOUNT_ERROR(103, "账号或密码错误"),
    CLASS_NO_CAN_SCH_TCH(1001, "班级无可排老师");

    private ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
