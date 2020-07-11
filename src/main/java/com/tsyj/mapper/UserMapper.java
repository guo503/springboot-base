package com.tsyj.mapper;

import com.tsyj.model.User;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户数据访问层
* @author guos
* @date 2020/07/11 17:38
*/
public interface UserMapper extends Mapper<User>, SoftDeleteMapper<User> {
}