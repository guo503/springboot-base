package com.tsyj.business;

import com.tsyj.ao.UserAO;
import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import java.util.*;

/**
* 用户service类
* @author guos
* @date 2020/07/11 17:38
*/
public interface UserBusiness {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2020/07/11 17:38
    * @return UserVO
    */
    UserVO get(Integer id);

    
    /**
    * 新增用户
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return int
    */
    int save(UserAO userAO);

    
    /**
    * 更新用户
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return int
    */
    int update(UserAO userAO);

    
    /**
    * 根据条件类查询用户列表
    * @param userAO userAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:38
    * @return Result<List<UserVO>>
    */
    Result<List<UserVO>> listByCondition(UserAO userAO, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询用户总数
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return int
    */
    int countByCondition(UserAO userAO);

    
    /**
    * 处理用户分批查询
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    */
    void doBatch(UserAO userAO);
}