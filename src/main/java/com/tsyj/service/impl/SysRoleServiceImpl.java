package com.tsyj.service.impl;

import com.tsyj.model.SysRole;
import com.tsyj.service.SysRoleService;
import com.tsyj.service.manage.SysRoleManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 角色表service实现类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleManage, SysRole> implements SysRoleService {
}