package com.tsyj.junit.test;

import com.tsyj.model.User;
import com.tsyj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: guos
 * @date: 2020
 * /3/26 11:00
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestController {

    @Autowired
    private UserService  userService;


    @Test
    public void getUser(){
        User user = userService.get(1);
        if(user!=null){
            System.out.println(user.getName());
        }
    }
}
