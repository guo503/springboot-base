package com.tsyj.service.manage.impl;

import com.tsyj.mapper.SysRoleMenuMapper;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.service.manage.SysRoleMenuManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 角色-菜单service实现类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysRoleMenuManageImpl extends ManageImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuManage {
}