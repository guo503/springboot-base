package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysRoleService;
import com.tsyj.vo.SysRoleVO;
import java.util.stream.Collectors;
import mybatis.base.template.business.BusinessImpl;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* 角色表业务类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysRoleBusinessImpl extends BusinessImpl<SysRoleService, SysRole, SysRoleQuery, SysRoleVO> implements SysRoleBusiness {
}