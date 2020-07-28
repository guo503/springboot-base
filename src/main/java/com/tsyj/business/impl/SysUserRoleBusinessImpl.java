package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysUserRoleService;
import com.tsyj.vo.SysUserRoleVO;
import java.util.stream.Collectors;
import mybatis.base.template.business.BusinessImpl;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* 用户-角色业务类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysUserRoleBusinessImpl extends BusinessImpl<SysUserRoleService, SysUserRole, SysUserRoleQuery, SysUserRoleVO> implements SysUserRoleBusiness {
}