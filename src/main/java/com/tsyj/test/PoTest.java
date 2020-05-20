package com.tsyj.test;

import java.util.Objects;

/**
 * @description:
 * @author: guos
 * @date: 2020/3/4 12:02
 **/
public class PoTest {

    public static void main(String[] args) {
     /*   User u1 = new User();
        u1.setName("u1");
        u1.setPhone("111");
        System.out.println(JsonUtils.objToJsonStringWithExcludeName(u1, Lists.newArrayList("phone", "row", "start", "version")));*/

        Integer a = 200, b = 300;
        Byte x = 3;
        System.out.println(Objects.equals(x.intValue(), 3));
        System.out.println(x == 3);
    }
}
