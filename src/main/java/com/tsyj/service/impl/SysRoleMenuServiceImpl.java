package com.tsyj.service.impl;

import com.tsyj.mapper.SysRoleMenuMapper;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.service.SysRoleMenuService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 角色-菜单service实现类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
}