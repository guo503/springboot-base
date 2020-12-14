package com.tsyj.business;

import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.vo.SysRoleVO;
import mybatis.base.template.bs.business.IBusiness;

/**
* 角色表service类
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysRoleBusiness extends IBusiness<SysRole, SysRoleQuery, SysRoleVO> {
}