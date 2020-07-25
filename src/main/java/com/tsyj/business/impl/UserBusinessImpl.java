package com.tsyj.business.impl;

import com.google.common.collect.Lists;
import com.tsyj.business.UserBusiness;
import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.response.Result;
import com.tsyj.service.UserService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.UserVO;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
* 用户业务类
* @author guos
* @date 2020/07/25 10:42
*/
@Service
public class UserBusinessImpl implements UserBusiness {
    
    @Autowired
    private UserService userService;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2020/07/25 10:42
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
    * @param user user
    * @author guos
    * @date 2020/07/25 10:42
    * @return int
    */
    @Override
    public int save(User user) {
        if (user == null) {
            throw new RuntimeException("用户信息不能为空!");
        }
        return userService.save(user);
    }

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2020/07/25 10:42
    * @return int
    */
    @Override
    public int update(User user) {
        if (user == null) {
            throw new RuntimeException("用户信息不能为空!");
        }
        return userService.update(user);
    }

    
    /**
    * 根据条件类查询用户列表
    * @param userQuery userQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/25 10:42
    * @return Result<List<UserVO>>
    */
    @Override
    public Result<List<UserVO>> listByCondition(UserQuery userQuery, int pageNum, int pageSize) {
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
    * @param userQuery userQuery
    * @author guos
    * @date 2020/07/25 10:42
    * @return int
    */
    @Override
    public int countByCondition(UserQuery userQuery) {
        Condition<User> userCond = new Condition<>();
        return userService.countByCondition(userCond);
    }

    
    /**
    * 处理用户分批查询
    * @param userQuery userQuery
    * @author guos
    * @date 2020/07/25 10:42
    */
    @Override
    public void doBatch(UserQuery userQuery) {
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