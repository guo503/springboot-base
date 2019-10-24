package com.tsyj.mapper;

import com.tsyj.model.User;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 用户数据访问层
* @author guos
* @date 2019/10/24 11:19
*/
public interface UserMapper extends Mapper<User>, SoftDeleteMapper<User> {
    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/10/24 11:19
    * @return int
    */
    int update(User user);
}