package com.tsyj.service.impl;

import com.tsyj.mapper.SysRoleMapper;
import com.tsyj.model.SysRole;
import com.tsyj.service.SysRoleService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 角色表service实现类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}