package com.tsyj.controller;

import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.vo.SysUserVO;
import mybatis.base.template.bs.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 用户表api类
* @author guos
* @date 2020/12/14 17:43
*/
@RestController
@RequestMapping("/sys-user")
public class SysUserController extends BaseController<SysUserBusiness, SysUser, SysUserQuery, SysUserVO> {
}