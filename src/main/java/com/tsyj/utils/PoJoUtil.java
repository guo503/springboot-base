package com.tsyj.utils;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author guos
 * @date 2020/8/8 9:37
 **/
public class PoJoUtil {


    public static void main(String[] args) {
        //User user = new User();
        //resetOperator(user);
        List<String> list = Lists.newArrayList("2020-08-01", "2020-08-02", "2020-08-01", "2020-08-03", "2020-08-03", "2020-08-04");
        Map<String, List<String>> listMap = list.stream().collect(Collectors.groupingBy(Objects::toString));
        listMap.forEach((k,v)->{
            System.out.println("k: "+k+"-->"+v);
        });
    }

    /**
     * 重置基础属性值
     *
     * @param t
     * @return
     * @author guos
     * @date 2020/8/8 9:38
     **/
    public static <T> void resetOperator(T t) {
        if (Objects.isNull(t)) {
            return;
        }
        //忽略原有字段
        List<String> ignoreList = Lists.newArrayList("crtName", "crtUser", "crtHost", "crtTime", "updName", "updUser", "updHost", "updTime");
        List<Field> fields = Lists.newArrayList(t.getClass().getDeclaredFields());
        fields.stream().filter(f -> Objects.equals(f.getModifiers(), Modifier.PRIVATE) && !Modifier.isStatic(f.getModifiers()))
                .forEach(f -> {
                    f.setAccessible(true);
                    if (ignoreList.contains(f.getName())) {
                        try {
                            //先置空
                            if (Objects.equals(f.getType(), Date.class)) {
                                f.set(t, new Date());
                            } else {
                                f.set(t, null);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(f.getName());
                });
    }
}
