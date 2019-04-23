package com.tsyj.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tsyj.cond.UserCond;
import com.tsyj.mapper.UserMapper;
import com.tsyj.page.Page;
import com.tsyj.po.User;
import com.tsyj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* 用户service实现类
* @author guos
* @date 2019/04/16 09:41
*/
@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/04/16 09:41
    * @return User
    */
    @Override
    public User get(Integer id) {
        logger.info("-----get------,param: {}",id);
        Assert.notNull(id,"id不能为空");
        return userMapper.get(id);
    }

    
    /**
    * 查询用户
    * @param id id
    * @param userCond userCond
    * @author guos
    * @date 2019/04/16 09:41
    * @return User
    */
    @Override
    public User get(Integer id, UserCond userCond) {
        logger.info("-----get------,param0:{},param1:{}",id,userCond);
        Assert.notNull(id,"id不能为空");
        if(userCond == null){
            userCond = new UserCond();
        }
        userCond.setId(id);
        List<User> list = this.list(userCond);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2019/04/16 09:41
    * @return int
    */
    @Override
    public int save(User user) {
        logger.info("-----save------,param: {}",user);
        Assert.notNull(user,"user不能为空");
        if (StringUtils.isEmpty(user.getCreator())) {
            user.setCreator("system");
        }
        if (StringUtils.isEmpty(user.getCreateTime())) {
            user.setCreateTime(new Date());
        }
        return userMapper.save(user);
    }

    
    /**
    * 新增并返回用户
    * @param user user
    * @author guos
    * @date 2019/04/16 09:41
    * @return User
    */
    @Transactional
    @Override
    public User saveAndGet(User user) {
        logger.info("-----saveAndGet------,param: {}",user);
        this.save(user);
        return this.get(user.getId());
    }

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/04/16 09:41
    * @return int
    */
    @Override
    public int update(User user) {
        logger.info("-----update------,param: {}",user);
        Assert.notNull(user,"user不能为空");
        User old = this.get(user.getId());
        if(old == null){
            throw new RuntimeException("用户信息不存在");
        }
        user.setVersion(old.getVersion());
        if (StringUtils.isEmpty(user.getUpdater())) {
            user.setUpdater("system");
        }
        if (StringUtils.isEmpty(user.getUpdateTime())) {
            user.setUpdateTime(new Date());
        }
        int count = userMapper.update(user);
        if(count == 0){
            throw new RuntimeException("用户信息更新失败");
        }
        return count;
    }

    
    /**
    * 查询用户列表
    * @param ids ids
    * @author guos
    * @date 2019/04/16 09:41
    * @return List<User>
    */
    @Override
    public List<User> listByIds(List<Integer> ids) {
        logger.info("-----listByIds------,param: {}",ids);
        Assert.notEmpty(ids,"ids不能为空");
        List<User> list = userMapper.listByIds(ids);
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list;
    }

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/04/16 09:41
    * @return List<User>
    */
    @Override
    public List<User> list(UserCond userCond) {
        logger.info("-----list------,param: {}",userCond);
        Assert.notNull(userCond,"userCond不能为空");
        List<User> list = userMapper.list(userCond);
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list;
    }

    
    /**
    * 查询用户总数
    * @param userCond userCond
    * @author guos
    * @date 2019/04/16 09:41
    * @return int
    */
    public int count(UserCond userCond) {
        logger.info("-----count------,param: {}",userCond);
        Assert.notNull(userCond,"userCond不能为空");
        return userMapper.count(userCond);
    }

    
    /**
    * 查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/04/16 09:41
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(UserCond userCond) {
        logger.info("-----listId------,param: {}",userCond);
        List<User> list = this.list(userCond);
        List<Integer> ids = list.stream().map(User::getId).distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        return ids;
    }

    
    /**
    * 将符合查询条件的用户列表转map
    * @param userCond userCond
    * @author guos
    * @date 2019/04/16 09:41
    * @return Map<Integer, User>
    */
    @Override
    public Map<Integer, User> map(UserCond userCond) {
        logger.info("-----map------,param: {}",userCond);
        List<User> list = this.list(userCond);
        Map<Integer,User> map = list.stream().collect(Collectors.toMap(User::getId,user -> user,(k1,k2)->k2));
        if (CollectionUtils.isEmpty(map)) {
            return  Maps.newHashMap();
        }
        return map;
    }

    
    /**
    * 将符合查询条件的用户列表转map
    * @param ids ids
    * @author guos
    * @date 2019/04/16 09:41
    * @return Map<Integer, User>
    */
    @Override
    public Map<Integer, User> mapByIds(List<Integer> ids) {
        logger.info("-----mapByIds------,param: {}",ids);
        List<User> list = this.listByIds(ids);
        Map<Integer,User> map = list.stream().collect(Collectors.toMap(User::getId,user -> user,(k1,k2)->k2));
        if (CollectionUtils.isEmpty(map)) {
            return  Maps.newHashMap();
        }
        return map;
    }

    
    /**
    * 分批查询用户
    * @param gtId gtId
    * @param userCond userCond
    * @author guos
    * @date 2019/04/16 09:41
    * @return List<User>
    */
    @Override
    public List<User> batchList(int gtId, UserCond userCond) {
        logger.info("-----batchList------,param0:{},param1:{}",gtId,userCond);
        Assert.notNull(userCond,"userCond不能为空");
        userCond.setGtId(gtId);
        userCond.setNum(1);
        userCond.setRow(Page.getMaxRow());
        return this.list(userCond);
    }
}