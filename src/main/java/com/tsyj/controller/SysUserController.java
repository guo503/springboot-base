package com.tsyj.controller;

import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.vo.SysUserVO;
import mybatis.base.template.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 用户表api类
* @author guos
* @date 2020/07/28 18:13
*/
@RestController
@RequestMapping("/sys-user")
public class SysUserController extends BaseController<SysUserBusiness, SysUser, SysUserQuery, SysUserVO> {
}