package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import java.util.*;

/**
* 用户service类
* @author guos
* @date 2019/10/26 14:30
*/
public interface UserBusiness {
    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/10/26 14:30
    * @return UserVO
    */
    UserVO get(Integer id);

    
    /**
    * 新增用户
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int save(UserVO userVO);

    
    /**
    * 更新用户
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int update(UserVO userVO);

    
    /**
    * 根据po查询用户列表
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    * @return Result<List<UserVO>>
    */
    Result<List<UserVO>> list(UserVO userVO);

    
    /**
    * 根据po查询用户总数
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    int count(UserVO userVO);

    
    /**
    * 处理用户分批查询
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    */
    void doBatch(UserVO userVO);
}