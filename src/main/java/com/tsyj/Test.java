package com.tsyj;

import com.google.common.collect.Lists;
import com.tsyj.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: guos
 * @date: 2019/9/5$ 12:04$
 **/
public class Test {

    private final static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        list.subList(8, 12).forEach(o -> {
            System.out.print(o + " ");
        });
        System.out.println("*************");
        StringBuilder labels = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int d = list.get(i);
            if (d == 0) {
                continue;
            }
            if (i == list.size() - 1) {
                labels.append(d);
            } else {
                labels.append(d).append(",");
            }
        }
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(",")));
        String res = labels.toString();
        System.out.println(res.charAt(res.length() - 1) == ',' ? res.substring(0, res.length() - 1) : res);


        List<String> list2 = Lists.newArrayList(null, null, null);
        System.out.println(CollectionUtils.isEmpty(list2));
        List<String> strings = Arrays.asList("l3u1c3_1".split("\\|\\|"));
        strings.forEach(s -> {
            System.out.print(s + " ");
        });
        System.out.println();
    }


}