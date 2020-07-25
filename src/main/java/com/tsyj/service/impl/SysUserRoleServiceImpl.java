package com.tsyj.service.impl;

import com.tsyj.model.SysUserRole;
import com.tsyj.service.SysUserRoleService;
import com.tsyj.service.manage.SysUserRoleManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 用户-角色service实现类
* @author guos
* @date 2020/07/24 16:57
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleManage, SysUserRole> implements SysUserRoleService {
}