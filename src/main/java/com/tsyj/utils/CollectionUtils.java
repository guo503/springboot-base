package com.tsyj.utils;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Description
 * @Author: guoshuai
 * @Date: create in 2018-01-05 11:13
 */
public class CollectionUtils extends org.springframework.util.CollectionUtils {

    public static void main(String[] args) {
      /*  String key = "root/";
        List<String> list = new ArrayList();
        list.add(key + "test1");
        list.add(key + "test2");
        list.add(key + "test3");
        list.add(key + "test2");
        int index = Collections.binarySearch(list, key + "test2");
        System.out.println(index);
        System.out.println(list.get(index - 1));*/

        List<Integer> ids = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> allList =splitList(ids,5);
        if(CollectionUtils.isEmpty(allList)){
            return;
        }
        allList.forEach(a->{
            a.forEach(b->System.out.println(b));
            System.out.println("*********************");
        });
    }


    public static <S, T> List<T> transfer(Collection<S> source) {
        ArrayList targetList = new ArrayList();
        if (source == null) return null;
        source.forEach(s -> targetList.add(s));
        return targetList;
    }


    /**
     * 多个非空list取交集
     *
     * @param paramLists
     * @return
     * @author guos
     * @date 2019/3/18 18:52
     **/
    @SafeVarargs
    public static <T> List<T> listIntersection(List<T>... paramLists) {
        if (paramLists == null || paramLists.length == 0) {
            return Lists.newArrayList();
        }
        for (List<T> list : paramLists) {
            if (CollectionUtils.isEmpty(list)) {
                return Lists.newArrayList();
            }
        }
        List<List<T>> lists = Lists.newArrayList(paramLists);
        Optional<List<T>> result = lists.parallelStream()
                //.filter(list -> !CollectionUtils.isEmpty(list))
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                });
        return result.orElse(Lists.newArrayList());
    }


    public static <T> T getLastElement(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }


    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param list
     * @param len
     * @return
     * @author guos
     * @date 2019/6/18 17:35
     **/
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        if (CollectionUtils.isEmpty(list) || len < 1) {
            return null;
        }
        List<List<T>> result = Lists.newArrayList();
        int size = list.size();
        int count = (size + len - 1) / len;

        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}
