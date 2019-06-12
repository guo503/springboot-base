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
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
* 用户业务类
* @author guos
* @date 2019/06/12 11:10
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
    * @date 2019/06/12 11:10
    * @return UserVO
    */
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
    * @date 2019/06/12 11:10
    * @return int
    */
    public int save(UserVO userVO) {
        logger.info("-----save------,param: {}",userVO);
        User user = new User();
        if(userVO != null) {
            BeanUtils.copyProperties(userVO, user);
        }
        return userService.save(user);
    }


    /**
    * 更新用户
    * @param userVO userVO
    * @author guos
    * @date 2019/06/12 11:10
    * @return int
    */
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
    * @date 2019/06/12 11:10
    * @return Result<List<UserVO>>
    */
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
    * @date 2019/06/12 11:10
    * @return int
    */
    public int count(UserVO userVO) {
        logger.info("-----count------,param: {}",userVO);
        UserCond userCond = new UserCond();
        BeanUtils.copyProperties(userVO, userCond);
        return userService.count(userCond);
    }


    /**
    * 处理用户分批查询
    * @param userVO userVO
    * @author guos
    * @date 2019/06/12 11:10
    */
    public void doBatch(UserVO userVO) {
        logger.info("-----doBatch------,param: {}",userVO);
        UserCond userCond = new UserCond();
        BeanUtils.copyProperties(userVO, userCond);
        int size = 2000;
        int gtId = 0;
        while (size >= 2000) {
            List<User> list = userService.batchList(gtId,userCond);
            if (CollectionUtils.isEmpty(list)) {
                return;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
            logger.info("-----doBatch------,param: {}",userVO);
        }
    }
}