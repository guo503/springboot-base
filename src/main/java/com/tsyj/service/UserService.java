package com.tsyj.service;

import com.tsyj.model.User;
import mybatis.core.entity.Condition;

import java.util.List;
import java.util.Map;

/**
* 用户service类
* @author guos
* @date 2019/10/26 14:30
*/
public interface UserService {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/10/26 14:30
    * @return User
    */
    User get(Integer id);

    
    /**
    * 根据user查询用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return User
    */
    User getOne(User user);

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int save(User user);

    
    /**
    * 新增并返回用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return User
    */
    User saveAndGet(User user);

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int update(User user);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    List<User> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询用户列表
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    List<User> list(User user);

    
    /**
    * 根据po查询用户总数
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int count(User user);

    
    /**
    * 根据条件类查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    List<User> listByCondition(Condition<User> userCond);

    
    /**
    * 根据条件类查询用户总数
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int countByCondition(Condition<User> userCond);

    
    /**
    * 
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<Integer>
    */
    List<Integer> listId(Condition<User> userCond);

    
    /**
    * 将符合查询条件的用户列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/26 14:30
    * @return Map<Integer, User>
    */
    Map<Integer, User> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的用户列表转map
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return Map<Integer, User>
    */
    Map<Integer, User> map(User user);

    
    /**
    * 分批查询用户
    * @param gtId gtId
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    List<User> batchList(int gtId, Condition<User> userCond);
}