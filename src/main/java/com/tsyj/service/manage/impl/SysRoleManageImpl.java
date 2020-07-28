package com.tsyj.service.manage.impl;

import com.tsyj.mapper.SysRoleMapper;
import com.tsyj.model.SysRole;
import com.tsyj.service.manage.SysRoleManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 角色表service实现类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysRoleManageImpl extends ManageImpl<SysRoleMapper, SysRole> implements SysRoleManage {
}