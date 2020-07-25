package com.tsyj.service.impl;

import com.tsyj.model.User;
import com.tsyj.service.UserService;
import com.tsyj.service.manage.UserManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 用户service实现类
* @author guos
* @date 2020/07/25 10:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserManage, User> implements UserService {
}