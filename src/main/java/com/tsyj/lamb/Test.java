package com.tsyj.lamb;

import com.alibaba.fastjson.JSONArray;

/**
 * @description:
 * @author: guos
 * @date: 2020/1/17 11:50
 **/
public class Test {

    public static void main(String[] args) throws Exception {
       String schIds ="[1,2,3]";
        JSONArray jsonArray = JSONArray.parseArray(schIds);
        for(Object o:jsonArray){
            System.out.println(o);
        }
    }
}
