package com.tsyj.controller;

import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.vo.SysRoleVO;
import mybatis.base.template.bs.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 角色表api类
* @author guos
* @date 2020/12/14 17:43
*/
@RestController
@RequestMapping("/sys-role")
public class SysRoleController extends BaseController<SysRoleBusiness, SysRole, SysRoleQuery, SysRoleVO> {
}