package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysMenuBusiness;
import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysMenuService;
import com.tsyj.vo.SysMenuVO;
import java.util.stream.Collectors;
import mybatis.base.template.business.BusinessImpl;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* 菜单表业务类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysMenuBusinessImpl extends BusinessImpl<SysMenuService, SysMenu, SysMenuQuery, SysMenuVO> implements SysMenuBusiness {
}