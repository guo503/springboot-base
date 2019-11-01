package com.tsyj.mapper;

import com.tsyj.model.SysRole;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 角色表数据访问层
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysRoleMapper extends Mapper<SysRole>, SoftDeleteMapper<SysRole> {
}