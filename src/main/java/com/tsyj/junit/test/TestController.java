package com.tsyj.junit.test;

import com.google.common.collect.Lists;
import com.tsyj.model.CountryCode;
import com.tsyj.service.manage.CountryCodeManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: guos
 * @date: 2020
 * /3/26 11:00
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestController {

    @Autowired
    private CountryCodeManage countryCodeManage;


    @Test
    public void getUser(){
        List<CountryCode> countryCodeList = countryCodeManage.listByIds(Lists.newArrayList(214, 215, 216));
        countryCodeList.forEach(System.out::println);
    }
}
