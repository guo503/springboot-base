package com.tsyj.mapper;

import com.tsyj.model.SysUser;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户表数据访问层
* @author guos
* @date 2020/07/11 17:24
*/
public interface SysUserMapper extends Mapper<SysUser>, SoftDeleteMapper<SysUser> {
}