package com.tsyj.test;

import com.google.common.collect.Lists;
import com.tsyj.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: guos
 * @date: 2020/3/4 12:02
 **/
public class PoTest {

    public static void main(String[] args) {
        int i = 1;
        i=i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }

    private static void show() {
        User user = new User();
        user.setId(1);
        user.setName("tsyj");
        List<Field> fields = Lists.newArrayList(User.class.getDeclaredFields());
        fields.stream().filter(f -> Objects.equals(f.getModifiers(), Modifier.PRIVATE)).forEach(f -> {
            System.out.println(f.getName() + "--->" + f.getModifiers());
            try {
                f.setAccessible(true);
                System.out.println(f.getName() + ": " + f.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
