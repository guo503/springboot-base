package com.tsyj.service;

import com.tsyj.model.User;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;

/**
* 用户service类
* @author guos
* @date 2019/10/24 10:33
*/
public interface UserService {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/10/24 10:33
    * @return User
    */
    User get(Integer id);

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2019/10/24 10:33
    * @return int
    */
    int save(User user);

    
    /**
    * 新增并返回用户
    * @param user user
    * @author guos
    * @date 2019/10/24 10:33
    * @return User
    */
    User saveAndGet(User user);

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/10/24 10:33
    * @return int
    */
    int update(User user);

    
    /**
    * 查询用户列表
    * @param ids ids
    * @author guos
    * @date 2019/10/24 10:33
    * @return List<User>
    */
    List<User> listByIds(List<Integer> ids);

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/10/24 10:33
    * @return List<User>
    */
    List<User> list(Condition<User> userCond);

    
    /**
    * 查询用户总数
    * @param userCond userCond
    * @author guos
    * @date 2019/10/24 10:33
    * @return int
    */
    int count(Condition<User> userCond);

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/10/24 10:33
    * @return List<Integer>
    */
    List<Integer> listId(Condition<User> userCond);

    
    /**
    * 将符合查询条件的用户列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/24 10:33
    * @return Map<Integer, User>
    */
    Map<Integer, User> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的用户列表转map
    * @param userCond userCond
    * @author guos
    * @date 2019/10/24 10:33
    * @return Map<Integer, User>
    */
    Map<Integer, User> map(Condition<User> userCond);

    
    /**
    * 分批查询用户
    * @param gtId gtId
    * @param userCond userCond
    * @author guos
    * @date 2019/10/24 10:33
    * @return List<User>
    */
    List<User> batchList(int gtId, Condition<User> userCond);
}