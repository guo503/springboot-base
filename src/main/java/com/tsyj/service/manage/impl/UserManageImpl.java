package com.tsyj.service.manage.impl;

import com.tsyj.mapper.UserMapper;
import com.tsyj.model.User;
import com.tsyj.service.manage.UserManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 用户service实现类
* @author guos
* @date 2020/07/25 10:42
*/
@Service
public class UserManageImpl extends ManageImpl<UserMapper, User> implements UserManage {
}