package com.tsyj.business;

import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.vo.SysMenuVO;
import mybatis.base.template.bs.business.IBusiness;

/**
* 菜单表service类
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysMenuBusiness extends IBusiness<SysMenu, SysMenuQuery, SysMenuVO> {
}