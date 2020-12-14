package com.tsyj.business.impl;

import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.service.SysRoleService;
import com.tsyj.vo.SysRoleVO;
import mybatis.base.template.bs.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 角色表业务类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysRoleBusinessImpl extends BusinessImpl<SysRoleService, SysRole, SysRoleQuery, SysRoleVO> implements SysRoleBusiness {
}