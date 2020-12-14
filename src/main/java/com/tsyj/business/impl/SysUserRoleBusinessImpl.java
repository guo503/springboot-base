package com.tsyj.business.impl;

import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.service.SysUserRoleService;
import com.tsyj.vo.SysUserRoleVO;
import mybatis.base.template.bs.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 用户-角色业务类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysUserRoleBusinessImpl extends BusinessImpl<SysUserRoleService, SysUserRole, SysUserRoleQuery, SysUserRoleVO> implements SysUserRoleBusiness {
}