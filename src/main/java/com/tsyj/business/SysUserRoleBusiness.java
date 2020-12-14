package com.tsyj.business;

import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.vo.SysUserRoleVO;
import mybatis.base.template.bs.business.IBusiness;

/**
* 用户-角色service类
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysUserRoleBusiness extends IBusiness<SysUserRole, SysUserRoleQuery, SysUserRoleVO> {
}