package com.tsyj.mapper;

import com.tsyj.model.SysUserRole;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户-角色数据访问层
* @author guos
* @date 2020/07/24 16:57
*/
public interface SysUserRoleMapper extends Mapper<SysUserRole>, SoftDeleteMapper<SysUserRole> {
}