package com.tsyj.service.impl;

import com.tsyj.mapper.SysUserRoleMapper;
import com.tsyj.model.SysUserRole;
import com.tsyj.service.SysUserRoleService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 用户-角色service实现类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}