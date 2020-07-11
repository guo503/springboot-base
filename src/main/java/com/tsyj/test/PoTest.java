package com.tsyj.test;

import com.tsyj.model.User;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @description:
 * @author: guos
 * @date: 2020/3/4 12:02
 **/
public class PoTest {

    public static void main(String[] args) {
        //BigDecimal var = new BigDecimal("10");
        //System.out.println(reset(var));

        Field[] declaredFields = User.class.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field.getType().getSimpleName());
        }
    }

    public static BigDecimal reset(BigDecimal var) {
        System.out.println(var.add(BigDecimal.ONE));
        var = var.add(BigDecimal.ONE);
        return var;
    }
}
