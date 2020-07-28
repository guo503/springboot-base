package com.tsyj.business;

import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;
import mybatis.base.template.business.IBusiness;

/**
* 用户-角色service类
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysUserRoleBusiness extends IBusiness<SysUserRole, SysUserRoleQuery, SysUserRoleVO> {
}