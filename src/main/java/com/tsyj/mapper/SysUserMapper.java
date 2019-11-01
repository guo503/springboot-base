package com.tsyj.mapper;

import com.tsyj.model.SysUser;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户表数据访问层
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysUserMapper extends Mapper<SysUser>, SoftDeleteMapper<SysUser> {
}