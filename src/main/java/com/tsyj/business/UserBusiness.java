package com.tsyj.business;

import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import java.util.*;

/**
* 用户service类
* @author guos
* @date 2020/07/25 10:42
*/
public interface UserBusiness {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2020/07/25 10:42
    * @return UserVO
    */
    UserVO get(Integer id);

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2020/07/25 10:42
    * @return int
    */
    int save(User user);

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2020/07/25 10:42
    * @return int
    */
    int update(User user);

    
    /**
    * 根据条件类查询用户列表
    * @param userQuery userQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/25 10:42
    * @return Result<List<UserVO>>
    */
    Result<List<UserVO>> listByCondition(UserQuery userQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询用户总数
    * @param userQuery userQuery
    * @author guos
    * @date 2020/07/25 10:42
    * @return int
    */
    int countByCondition(UserQuery userQuery);

    
    /**
    * 处理用户分批查询
    * @param userQuery userQuery
    * @author guos
    * @date 2020/07/25 10:42
    */
    void doBatch(UserQuery userQuery);
}