package com.tsyj.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author guos
 * @date 2020/7/28 9:26
 **/
public class GenericUtils {

    public static <T> T getInstance(Class<?> paramClz, int index) {
        try {
            Type type = paramClz.getGenericSuperclass();
            if (Objects.isNull(type)) {
                return null;
            }
            ParameterizedType parameterizedType = null;
            if (type instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) type;
            }
            if (parameterizedType == null) {
                return null;
            }
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types.length == 0) {
                return null;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (index >= actualTypeArguments.length) {
                return null;
            }
            Type realType = parameterizedType.getActualTypeArguments()[index];
            Class<T> clz = (Class<T>) realType;
            return clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
