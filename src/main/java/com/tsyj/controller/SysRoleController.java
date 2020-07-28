package com.tsyj.controller;

import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.vo.SysRoleVO;
import mybatis.base.template.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 角色表api类
* @author guos
* @date 2020/07/28 18:13
*/
@RestController
@RequestMapping("/sys-role")
public class SysRoleController extends BaseController<SysRoleBusiness, SysRole, SysRoleQuery, SysRoleVO> {
}