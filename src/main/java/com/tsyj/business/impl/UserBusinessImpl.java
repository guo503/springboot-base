package com.tsyj.business.impl;

import com.google.common.collect.Lists;
import com.tsyj.business.UserBusiness;
import com.tsyj.cond.UserCond;
import com.tsyj.po.User;
import com.tsyj.response.Result;
import com.tsyj.service.UserService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 用户业务类
* @author guos
* @date 2019/07/04 15:32
*/
@Service
public class UserBusinessImpl implements UserBusiness {
    
    private static final Logger logger = LoggerFactory.getLogger(UserBusinessImpl.class);

    @Autowired
    private UserService userService;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/07/04 15:32
    * @return UserVO
    */
    @Override
    public UserVO get(Integer id) {
        logger.info("-----get------,param: {}",id);
        User user = userService.get(id);
        UserVO userVO = new UserVO();
        if(user != null) {
            BeanUtils.copyProperties(user, userVO);
        }
        return userVO;
    }

    
    /**
    * 新增用户
    * @param userVO userVO
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    @Override
    public int save(UserVO userVO) {
        logger.info("-----save------,param: {}",userVO);
        User user = new User();
        if(userVO != null) {
            BeanUtils.copyProperties(userVO, user);
        }
        return userService.save(user);
    }

    
    /**
    * 根据条件物理删除用户
    * @param userVO userVO
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    @Override
    public int realDelete(UserVO userVO) {
        logger.info("-----realDelete------,param: {}",userVO);
        UserCond userCond = new UserCond();
        BeanUtils.copyProperties(userVO, userCond);
        return userService.realDelete(userCond);
    }

    
    /**
    * 更新用户
    * @param userVO userVO
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    @Override
    public int update(UserVO userVO) {
        logger.info("-----update------,param: {}",userVO);
        User user = new User();
        if(userVO != null) {
            BeanUtils.copyProperties(userVO, user);
        }
        return userService.update(user);
    }

    
    /**
    * 查询用户列表
    * @param userVO userVO
    * @author guos
    * @date 2019/07/04 15:32
    * @return Result<List<UserVO>>
    */
    @Override
    public Result<List<UserVO>> list(UserVO userVO) {
        logger.info("-----list------,param: {}",userVO);
        Result<List<UserVO>> result = Result.success(Lists.newArrayList(), 0);
        UserCond userCond = new UserCond();
        BeanUtils.copyProperties(userVO, userCond);
        int count = userService.count(userCond);
        if (count == 0){
            return result;
        }
        List<UserVO> userVOList = ModelConvertUtils.convertList(UserVO.class, userService.list(userCond));
        return Result.success(userVOList, count);
    }

    
    /**
    * 查询用户总数
    * @param userVO userVO
    * @author guos
    * @date 2019/07/04 15:32
    * @return int
    */
    @Override
    public int count(UserVO userVO) {
        logger.info("-----count------,param: {}",userVO);
        UserCond userCond = new UserCond();
        BeanUtils.copyProperties(userVO, userCond);
        return userService.count(userCond);
    }
}