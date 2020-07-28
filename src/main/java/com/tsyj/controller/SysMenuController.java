package com.tsyj.controller;

import com.tsyj.business.SysMenuBusiness;
import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.vo.SysMenuVO;
import mybatis.base.template.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 菜单表api类
* @author guos
* @date 2020/07/28 18:13
*/
@RestController
@RequestMapping("/sys-menu")
public class SysMenuController extends BaseController<SysMenuBusiness, SysMenu, SysMenuQuery, SysMenuVO> {
}