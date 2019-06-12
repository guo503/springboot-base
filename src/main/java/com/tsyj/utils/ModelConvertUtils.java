package com.tsyj.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 对象转换工具类
 * author: guos
 * date: 2019/6/12 10:33
 **/
public class ModelConvertUtils {

    private static <T> T convert(Class<T> type, Object o) {
        try {
            T t = type.newInstance();
            BeanUtils.copyProperties(o, t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("对象convert出错");
        }

    }

    /**
     * 对象列表转换工具类
     *
     * @param target
     * @param list   author  guos
     *               date 2019/6/12 10:33
     *               return
     **/
    public static <T, V> List<T> convertList(Class<T> target, List<V> list) {
        if (list == null) {
            throw new IllegalArgumentException("list is empty");
        }
        List<T> targetList = new ArrayList<T>();

        list.stream().forEach(e -> {
            targetList.add(convert(target, e));

        });
        return targetList;
    }
}
