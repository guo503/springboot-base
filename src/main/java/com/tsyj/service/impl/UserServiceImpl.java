package com.tsyj.service.impl;

import com.google.common.collect.Lists;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.UserMapper;
import com.tsyj.model.User;
import com.tsyj.page.Page;
import com.tsyj.service.UserService;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* 用户service实现类
* @author guos
* @date 2019/10/26 14:30
*/
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/10/26 14:30
    * @return User
    */
    @Override
    public User get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return userMapper.getx(id);
    }

    
    /**
    * 根据user查询用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return User
    */
    @Override
    public User getOne(User user) {
        Assert.notNull(user,"user不能为空");
        return userMapper.getOnex(user);
    }

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    @Override
    public int save(User user) {
        Assert.notNull(user,"user不能为空");
        if (StringUtils.isEmpty(user.getCreator())) {
            user.setCreator(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(user.getCreateTime())) {
            user.setCreateTime(new Date());
        }
        return userMapper.savex(user);
    }

    
    /**
    * 新增并返回用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return User
    */
    @Transactional
    @Override
    public User saveAndGet(User user) {
        this.save(user);
        return this.get(user.getId());
    }

    
    /**
    * 更新用户
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    @Override
    public int update(User user) {
        Assert.notNull(user,"user不能为空");
        User old = this.get(user.getId());
        if (old == null){
            throw new RuntimeException("用户信息不存在!");
        }
        user.setVersion(old.getVersion());
        if (StringUtils.isEmpty(user.getUpdater())) {
            user.setUpdater(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(user.getUpdateTime())) {
            user.setUpdateTime(new Date());
        }
        int count = userMapper.updatex(user);
        if (count == 0){
            throw new RuntimeException("用户信息更新失败!");
        }
        return count;
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    @Override
    public List<User> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<User> userCond = new Condition<>();
        userCond.createCriteria().andIn(User.ID, ids);
        userCond.limit(Page.getMaxRow());
        return this.listByCondition(userCond);
    }

    
    /**
    * 根据po查询用户列表
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    @Override
    public List<User> list(User user) {
        Assert.notNull(user,"user不能为空");
        return userMapper.listLimitx(user, new LimitCondition(user.getStart(), user.getRow()));
    }

    
    /**
    * 根据po查询用户总数
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    public int count(User user) {
        Assert.notNull(user,"user不能为空");
        return userMapper.countx(user);
    }

    
    /**
    * 根据条件类查询用户列表
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    @Override
    public List<User> listByCondition(Condition<User> userCond) {
        Assert.notNull(userCond,"userCond不能为空");
        return userMapper.listByConditionx(userCond);
    }

    
    /**
    * 根据条件类查询用户总数
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return int
    */
    public int countByCondition(Condition<User> userCond) {
        Assert.notNull(userCond,"userCond不能为空");
        return userMapper.countByConditionx(userCond);
    }

    
    /**
    * 
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<User> userCond) {
        List<User> list = this.listByCondition(userCond);
        return list.stream().map(User::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的用户列表转map
    * @param user user
    * @author guos
    * @date 2019/10/26 14:30
    * @return Map<Integer, User>
    */
    @Override
    public Map<Integer, User> map(User user) {
        List<User> userList = this.list(user);
        return userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

    
    /**
    * 将符合查询条件的用户列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/26 14:30
    * @return Map<Integer, User>
    */
    @Override
    public Map<Integer, User> mapByIds(List<Integer> ids) {
        List<User> userList = this.listByIds(ids);
        return userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
    }

    
    /**
    * 分批查询用户
    * @param gtId gtId
    * @param userCond userCond
    * @author guos
    * @date 2019/10/26 14:30
    * @return List<User>
    */
    @Override
    public List<User> batchList(int gtId, Condition<User> userCond) {
        Assert.notNull(userCond,"userCond不能为空");
        userCond.limit(1,Page.getMaxRow() - 1);
        userCond.setOrderBy(User.ID);
        userCond.andCriteria().andGreaterThan(User.ID, gtId);
        return this.listByCondition(userCond);
    }
}