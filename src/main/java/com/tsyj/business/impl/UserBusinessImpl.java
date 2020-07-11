package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.ao.UserAO;
import com.tsyj.business.UserBusiness;
import com.tsyj.model.User;
import com.tsyj.response.Result;
import com.tsyj.service.UserService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.UserVO;
import java.util.*;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 用户业务类
* @author guos
* @date 2020/07/11 17:38
*/
@Service
public class UserBusinessImpl implements UserBusiness {
    
    @Autowired
    private UserService userService;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2020/07/11 17:38
    * @return UserVO
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
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return int
    */
    @Override
    public int save(UserAO userAO) {
        if (userAO == null) {
            throw new RuntimeException("用户信息不能为空!");
        }
        User user = new User();
        BeanUtils.copyProperties(userAO, user);
        return userService.save(user);
    }

    
    /**
    * 更新用户
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return int
    */
    @Override
    public int update(UserAO userAO) {
        if (userAO == null) {
            throw new RuntimeException("用户信息不能为空!");
        }
        User user = new User();
        BeanUtils.copyProperties(userAO, user);
        return userService.update(user);
    }

    
    /**
    * 根据条件类查询用户列表
    * @param userAO userAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:38
    * @return Result<List<UserVO>>
    */
    @Override
    public Result<List<UserVO>> listByCondition(UserAO userAO, int pageNum, int pageSize) {
        Result<List<UserVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<User> userCond = new Condition<>();
        userCond.limit(pageNum, pageSize);
        int count = userService.countByCondition(userCond);
        if (count == 0){
            return result;
        }
        List<UserVO> userVOList = ModelConvertUtils.convertList(UserVO.class, userService.listByCondition(userCond));
        return Result.success(userVOList, count);
    }

    
    /**
    * 根据条件类查询用户总数
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return int
    */
    @Override
    public int countByCondition(UserAO userAO) {
        Condition<User> userCond = new Condition<>();
        return userService.countByCondition(userCond);
    }

    
    /**
    * 处理用户分批查询
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    */
    @Override
    public void doBatch(UserAO userAO) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<User> userCond = new Condition<>();
        userCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<User> list = userService.batchList(gtId,userCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}