package com.tsyj.test;

import com.google.common.collect.Lists;
import com.tsyj.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: guos
 * @date: 2020/3/4 12:02
 **/
public class PoTest {

    public static void main(String[] args) {
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

    public static BigDecimal reset(BigDecimal var) {
        System.out.println(var.add(BigDecimal.ONE));
        var = var.add(BigDecimal.ONE);
        return var;
    }
}
