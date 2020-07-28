package com.tsyj.business;

import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import java.util.*;
import mybatis.base.template.business.IBusiness;

/**
* 菜单表service类
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysMenuBusiness extends IBusiness<SysMenu, SysMenuQuery, SysMenuVO> {
}