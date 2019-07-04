package com.tsyj.service;

import com.tsyj.cond.UserCond;
import com.tsyj.po.User;
import java.util.*;
import java.util.Map;

/**
* 用户service类
* @author guos
* @date 2019/07/04 15:32
*/
public interface UserService {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/07/04 15:32
    * @return User
    */
    User get(Integer id);

    
    /**
    * 查询用户
    * @param id id
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return User
    */
    User get(Integer id, UserCond userCond);

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    int save(User user);

    
    /**
    * 新增并返回用户
    * @param user user
    * @author guos
    * @date 2019/07/04 15:32
    * @return User
    */
    User saveAndGet(User user);

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    int update(User user);

    
    /**
    * 根据条件物理删除用户
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    int realDelete(UserCond userCond);

    
    /**
    * 查询用户列表
    * @param ids ids
    * @author guos
    * @date 2019/07/04 15:32
    * @return List<User>
    */
    List<User> listByIds(List<Integer> ids);

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return List<User>
    */
    List<User> list(UserCond userCond);

    
    /**
    * 查询用户总数
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    int count(UserCond userCond);

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return List<Integer>
    */
    List<Integer> listId(UserCond userCond);

    
    /**
    * 将符合查询条件的用户列表转map
    * @param ids ids
    * @author guos
    * @date 2019/07/04 15:32
    * @return Map<Integer, User>
    */
    Map<Integer, User> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的用户列表转map
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return Map<Integer, User>
    */
    Map<Integer, User> map(UserCond userCond);

    
    /**
    * 分批查询用户
    * @param gtId gtId
    * @param userCond userCond
    * @author guos
    * @date 2019/07/04 15:32
    * @return List<User>
    */
    List<User> batchList(int gtId, UserCond userCond);
}