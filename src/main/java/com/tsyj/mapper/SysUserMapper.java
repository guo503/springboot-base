package com.tsyj.mapper;

import com.tsyj.model.SysUser;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户表数据访问层
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysUserMapper extends Mapper<SysUser>, SoftDeleteMapper<SysUser> {
}