package com.tsyj.mapper;

import com.tsyj.model.SysUserRole;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户-角色数据访问层
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysUserRoleMapper extends Mapper<SysUserRole>, SoftDeleteMapper<SysUserRole> {
}