package com.tsyj.business;

import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.vo.SysRoleMenuVO;
import mybatis.base.template.bs.business.IBusiness;

/**
* 角色-菜单service类
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysRoleMenuBusiness extends IBusiness<SysRoleMenu, SysRoleMenuQuery, SysRoleMenuVO> {
}