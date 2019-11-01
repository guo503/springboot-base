package com.tsyj.mapper;

import com.tsyj.model.SysRoleMenu;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 角色-菜单数据访问层
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysRoleMenuMapper extends Mapper<SysRoleMenu>, SoftDeleteMapper<SysRoleMenu> {
}