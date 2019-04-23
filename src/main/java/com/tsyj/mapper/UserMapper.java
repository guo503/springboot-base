package com.tsyj.mapper;

import com.tsyj.cond.UserCond;
import com.tsyj.po.User;
import java.util.List;

/**
* 用户数据访问层
* @author guos
* @date 2019/04/11 16:26
*/
public interface UserMapper {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/04/11 16:26
    * @return User
    */
    User get(Integer id);

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2019/04/11 16:26
    * @return int
    */
    int save(User user);

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/04/11 16:26
    * @return int
    */
    int update(User user);

    
    /**
    * 查询用户列表
    * @param ids ids
    * @author guos
    * @date 2019/04/11 16:26
    * @return List<User>
    */
    List<User> listByIds(List<Integer> ids);

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/04/11 16:26
    * @return List<User>
    */
    List<User> list(UserCond userCond);

    
    /**
    * 查询用户总数
    * @param userCond userCond
    * @author guos
    * @date 2019/04/11 16:26
    * @return int
    */
    int count(UserCond userCond);
}