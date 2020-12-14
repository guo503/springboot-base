package com.tsyj.service.impl;

import com.tsyj.mapper.UserMapper;
import com.tsyj.model.User;
import com.tsyj.service.UserService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 用户service实现类
* @author guos
* @date 2020/12/12 16:28
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}