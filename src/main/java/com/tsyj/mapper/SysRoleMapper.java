package com.tsyj.mapper;

import com.tsyj.model.SysRole;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 角色表数据访问层
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysRoleMapper extends Mapper<SysRole>, SoftDeleteMapper<SysRole> {
}