package com.tsyj.controller;

import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.vo.SysRoleMenuVO;
import mybatis.base.template.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 角色-菜单api类
* @author guos
* @date 2020/07/28 18:13
*/
@RestController
@RequestMapping("/sys-role-menu")
public class SysRoleMenuController extends BaseController<SysRoleMenuBusiness, SysRoleMenu, SysRoleMenuQuery, SysRoleMenuVO> {
}