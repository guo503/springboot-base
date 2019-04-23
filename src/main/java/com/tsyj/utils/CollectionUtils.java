package com.tsyj.utils;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Description
 * @Author: guoshuai
 * @Date: create in 2018-01-05 11:13
 */
public class CollectionUtils extends org.springframework.util.CollectionUtils {

    public static <S, T> List<T> transfer(Collection<S> source) {
        ArrayList targetList = new ArrayList();
        if (source == null) return null;
        source.forEach(s -> targetList.add(s));
        return targetList;
    }


    public static void main(String[] args) {
        String key = "root/";
        List<String> list = new ArrayList();
        list.add(key + "test1");
        list.add(key + "test2");
        list.add(key + "test3");
        list.add(key + "test2");
        int index = Collections.binarySearch(list, key + "test2");
        System.out.println(index);
        System.out.println(list.get(index - 1));
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


    private static <T> List<T> batchList(List<T> list){
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return null;
    }
}
