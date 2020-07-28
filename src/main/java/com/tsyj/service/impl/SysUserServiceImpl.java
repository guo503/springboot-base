package com.tsyj.service.impl;

import com.tsyj.model.SysUser;
import com.tsyj.service.SysUserService;
import com.tsyj.service.manage.SysUserManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 用户表service实现类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserManage, SysUser> implements SysUserService {
}