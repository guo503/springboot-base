package com.tsyj.controller;

import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.vo.SysUserRoleVO;
import mybatis.base.template.bs.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 用户-角色api类
* @author guos
* @date 2020/12/14 17:43
*/
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController extends BaseController<SysUserRoleBusiness, SysUserRole, SysUserRoleQuery, SysUserRoleVO> {
}