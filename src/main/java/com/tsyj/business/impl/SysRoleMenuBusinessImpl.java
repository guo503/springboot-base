package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.stream.Collectors;
import mybatis.base.template.business.BusinessImpl;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* 角色-菜单业务类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysRoleMenuBusinessImpl extends BusinessImpl<SysRoleMenuService, SysRoleMenu, SysRoleMenuQuery, SysRoleMenuVO> implements SysRoleMenuBusiness {
}