package com.tsyj.service.manage.impl;

import com.tsyj.mapper.SysUserRoleMapper;
import com.tsyj.model.SysUserRole;
import com.tsyj.service.manage.SysUserRoleManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 用户-角色service实现类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysUserRoleManageImpl extends ManageImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleManage {
}