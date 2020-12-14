package com.tsyj.business.impl;

import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.vo.SysRoleMenuVO;
import mybatis.base.template.bs.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 角色-菜单业务类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysRoleMenuBusinessImpl extends BusinessImpl<SysRoleMenuService, SysRoleMenu, SysRoleMenuQuery, SysRoleMenuVO> implements SysRoleMenuBusiness {
}