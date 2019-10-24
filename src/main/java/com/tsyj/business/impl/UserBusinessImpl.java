package com.tsyj.business.impl;


import com.google.common.collect.Lists;
import com.tsyj.business.UserBusiness;
import com.tsyj.model.User;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.UserService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.UserVO;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户业务类
 *
 * @author guos
 * @date 2019/10/24 11:13
 */
@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private UserService userService;


    /**
     * 查询用户
     *
     * @param id id
     * @return UserVO
     * @author guos
     * @date 2019/10/24 11:13
     */
    @Override
    public UserVO get(Integer id) {
        User user = userService.get(id);
        UserVO userVO = new UserVO();
        if (user == null) {
            return userVO;
        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }


    /**
     * 新增用户
     *
     * @param userVO userVO
     * @return int
     * @author guos
     * @date 2019/10/24 11:13
     */
    @Override
    public int save(UserVO userVO) {
        if (userVO == null) {
            throw new RuntimeException("用户信息不能为空!");
        }
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return userService.save(user);
    }


    /**
     * 更新用户
     *
     * @param userVO userVO
     * @return int
     * @author guos
     * @date 2019/10/24 11:13
     */
    @Override
    public int update(UserVO userVO) {
        if (userVO == null) {
            throw new RuntimeException("用户信息不能为空!");
        }
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return userService.update(user);
    }


    /**
     * 查询用户列表
     *
     * @param userVO userVO
     * @return Result<List < UserVO>>
     * @author guos
     * @date 2019/10/24 11:13
     */
    @Override
    public Result<List<UserVO>> list(UserVO userVO) {
        Result<List<UserVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<User> userCond = new Condition<>();
        userCond.limit(userVO.getNum(), userVO.getRow());
        int count = userService.count(userCond);
        if (count == 0) {
            return result;
        }
        List<UserVO> userVOList = ModelConvertUtils.convertList(UserVO.class, userService.list(userCond));
        return Result.success(userVOList, count);
    }


    /**
     * 查询用户总数
     *
     * @param userVO userVO
     * @return int
     * @author guos
     * @date 2019/10/24 11:13
     */
    @Override
    public int count(UserVO userVO) {
        Condition<User> userCond = new Condition<>();
        return userService.count(userCond);
    }

    /**
     * 处理用户分批查询
     *
     * @param userVO userVO
     * @author guos
     * @date 2019/10/24 11:16
     */
    @Override
    public void doBatch(UserVO userVO) {
        Condition<User> userCond = new Condition<>();
        int size = Page.getMaxRow() - 1;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<User> list = userService.batchList(gtId, userCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }


}
