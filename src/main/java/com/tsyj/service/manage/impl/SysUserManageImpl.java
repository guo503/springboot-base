package com.tsyj.service.manage.impl;

import com.tsyj.mapper.SysUserMapper;
import com.tsyj.model.SysUser;
import com.tsyj.service.manage.SysUserManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 用户表service实现类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysUserManageImpl extends ManageImpl<SysUserMapper, SysUser> implements SysUserManage {
}