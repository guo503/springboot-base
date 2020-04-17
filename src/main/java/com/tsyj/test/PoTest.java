package com.tsyj.test;

import com.google.common.collect.Lists;
import com.tsyj.model.User;
import com.tsyj.utils.JsonUtils;

/**
 * @description:
 * @author: guos
 * @date: 2020/3/4 12:02
 **/
public class PoTest {

    public static void main(String[] args) {
        User u1 = new User();
        u1.setName("u1");
        u1.setPhone("111");
        System.out.println(JsonUtils.objToJsonStringWithExcludeName(u1, Lists.newArrayList("phone", "row", "start", "version")));
    }
}
