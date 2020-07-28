package com.tsyj.business;

import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;
import mybatis.base.template.business.IBusiness;

/**
* 角色-菜单service类
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysRoleMenuBusiness extends IBusiness<SysRoleMenu, SysRoleMenuQuery, SysRoleMenuVO> {
}