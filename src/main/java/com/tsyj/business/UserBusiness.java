package com.tsyj.business;


import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;

import java.util.List;

/**
 * 用户service类
 *
 * @author guos
 * @date 2019/10/24 11:13
 */
public interface UserBusiness {

    /**
     * 查询用户
     *
     * @param id id
     * @return UserVO
     * @author guos
     * @date 2019/10/24 11:13
     */
    UserVO get(Integer id);


    /**
     * 新增用户
     *
     * @param userVO userVO
     * @return int
     * @author guos
     * @date 2019/10/24 11:13
     */
    int save(UserVO userVO);


    /**
     * 更新用户
     *
     * @param userVO userVO
     * @return int
     * @author guos
     * @date 2019/10/24 11:13
     */
    int update(UserVO userVO);


    /**
     * 查询用户列表
     *
     * @param userVO userVO
     * @return Result<List < UserVO>>
     * @author guos
     * @date 2019/10/24 11:13
     */
    Result<List<UserVO>> list(UserVO userVO);


    /**
     * 查询用户总数
     *
     * @param userVO userVO
     * @return int
     * @author guos
     * @date 2019/10/24 11:13
     */
    int count(UserVO userVO);

    /**
     * 处理用户分批查询
     *
     * @param userVO userVO
     * @author guos
     * @date 2019/10/24 11:16
     */
    void doBatch(UserVO userVO);


}
