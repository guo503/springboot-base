package com.tsyj.business.impl;

import com.tsyj.business.SysMenuBusiness;
import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.service.SysMenuService;
import com.tsyj.vo.SysMenuVO;
import mybatis.base.template.bs.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 菜单表业务类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysMenuBusinessImpl extends BusinessImpl<SysMenuService, SysMenu, SysMenuQuery, SysMenuVO> implements SysMenuBusiness {
}