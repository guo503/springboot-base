package com.tsyj.test;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author guos
 * @date 2020/11/10 9:54
 **/
public class DrugTest {


    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put("a",111);
        hm.put("b",222);
        HashSet hs = new HashSet();
        Hashtable ht = new Hashtable();
        TreeMap tm = new TreeMap();

        List<HashMap> list = Lists.newArrayList();
        list.add(hm);
        System.out.println(JSONArray.toJSONString(list));

    }


    public static boolean check(Object o) {
        return Boolean.parseBoolean(String.valueOf(o));
    }


    /**
     * 提取字符串数字
     *
     * @param s
     * @return
     * @author guos
     * @date 2020/11/26 20:40
     **/
    public static String getNumber(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        return m.replaceAll("").trim();
    }


}
