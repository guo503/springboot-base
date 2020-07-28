package com.tsyj.mapper;

import com.tsyj.model.SysRoleMenu;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 角色-菜单数据访问层
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysRoleMenuMapper extends Mapper<SysRoleMenu>, SoftDeleteMapper<SysRoleMenu> {
}