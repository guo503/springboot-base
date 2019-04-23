package com.tsyj.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:比较对象属性
 * @Author: guos
 * @Date: create in 2018-03-07 9:11
 */
public class ContractObjUtils {

    /**
     * 根据指定属性判断2个对象响应的属性值是否相等
     *
     * @param o1
     * @param o2
     * @return
     * @throws Exception
     */
    public static boolean contractObj(Object o1, Object o2, String attr) {
        String name = attr.substring(0, 1).toUpperCase() + attr.substring(1);
        Class o1Class = o1.getClass();
        try {
            Method method = o1Class.getMethod("get" + name);
            Object res1 = method.invoke(o1);
            Object res2 = method.invoke(o2);
            if ((res1 != null && res1.equals(res2)) || (res2 != null && res2.equals(res1))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 根据各集合数据分类返回
     *
     * @param old
     * @param news
     * @return
     */
    public static <T> Map getData(List<T> old, List<T> news, String attr) {
        Map map = new HashMap();
        List<T> updateList = new ArrayList<>();//需要更新的对象
        List<T> oldUpdateList = new ArrayList<>();//需要更新的对象
        List<T> insertList = new ArrayList<>();//需要插入的对象
        List<T> deleteList = new ArrayList<>();//需要删除的对象
        if (old.size() == 0 || news.size() == 0) {
            return null;
        }
        boolean hasFind = false;
        for (T o1 : news) {
            for (T o2 : old) {
                if (contractObj(o1, o2, attr)) {
                    hasFind = true;
                    oldUpdateList.add(o2);
                    break;
                }
            }
            if (hasFind) {
                updateList.add(o1);
            } else {
                insertList.add(o1);
            }
        }
        hasFind = false;
        for (T t1 : old) {
            for (T t2 : news) {
                if (contractObj(t1, t2, attr)) {
                    hasFind = true;
                    break;
                }
            }
            if (!hasFind) {
                deleteList.add(t1);
            }
        }
        map.put("updateList", updateList);
        map.put("oldUpdateList", oldUpdateList);
        map.put("insertList", insertList);
        map.put("deleteList", deleteList);
        return map;
    }
}
