package com.tsyj.test;

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
        String var = "13910";
        System.out.println(var == "13910");
    }

    public static BigDecimal reset(BigDecimal var) {
        System.out.println(var.add(BigDecimal.ONE));
        var = var.add(BigDecimal.ONE);
        return var;
    }
}
