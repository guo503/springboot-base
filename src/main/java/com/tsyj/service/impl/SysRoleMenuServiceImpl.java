package com.tsyj.service.impl;

import com.tsyj.model.SysRoleMenu;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.service.manage.SysRoleMenuManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 角色-菜单service实现类
* @author guos
* @date 2020/07/11 17:24
*/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuManage, SysRoleMenu> implements SysRoleMenuService {
}