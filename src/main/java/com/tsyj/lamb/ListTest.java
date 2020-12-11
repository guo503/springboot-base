package com.tsyj.lamb;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author: guos
 * @date: 2020/1/3 15:36
 **/
public class ListTest {

    public static void main(String[] args) {
        Runnable r = (Runnable & Serializable)() -> System.out.println("Serializable!");
    }


    /**
     * list对象属性去重
     *
     * @param
     * @return
     * @author guos
     * @date 2020/1/3 15:56
     **/
    private static void distinct() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("xxx");

        User user2 = new User();
        user2.setId(2);
        user2.setName("xxx");
        ArrayList<User> users = Lists.newArrayList(user1, user2);

        //去重
        List<User> uni = users.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new)
        );
        uni.forEach(a -> {
            System.out.println("user->" + a.getName());
        });
    }


    /**
     * list对象拼接
     *
     * @param
     * @return
     * @author guos
     * @date 2020/1/3 15:58
     **/
    private static void joinField() {
        List<Integer> list = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(",")));
    }


}
