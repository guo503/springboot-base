package com.tsyj.business;

import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleVO;
import java.util.*;
import mybatis.base.template.business.IBusiness;

/**
* 角色表service类
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysRoleBusiness extends IBusiness<SysRole, SysRoleQuery, SysRoleVO> {
}