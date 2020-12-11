package com.tsyj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数校验非null
 *
 * @author guos
 * @date 2018年1月24日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    /**
     * 参数字段
     */
    String[] value();
}
