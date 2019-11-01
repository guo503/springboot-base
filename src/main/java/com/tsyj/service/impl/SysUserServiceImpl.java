package com.tsyj.service.impl;

import com.google.common.collect.*;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.SysUserMapper;
import com.tsyj.model.SysUser;
import com.tsyj.page.Page;
import com.tsyj.service.SysUserService;
import java.util.*;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.*;
import org.springframework.util.Assert;

/**
* 用户表service实现类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;

    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUser
    */
    @Override
    public SysUser get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return sysUserMapper.getx(id);
    }

    
    /**
    * 根据sysUser查询用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUser
    */
    @Override
    public SysUser getOne(SysUser sysUser) {
        Assert.notNull(sysUser,"sysUser不能为空");
        return sysUserMapper.getOnex(sysUser);
    }

    
    /**
    * 新增用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysUser sysUser) {
        Assert.notNull(sysUser,"sysUser不能为空");
        if (StringUtils.isEmpty(sysUser.getCreator())) {
            sysUser.setCreator(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysUser.getCreateTime())) {
            sysUser.setCreateTime(new Date());
        }
        return sysUserMapper.savex(sysUser);
    }

    
    /**
    * 新增并返回用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUser
    */
    @Transactional
    @Override
    public SysUser saveAndGet(SysUser sysUser) {
        this.save(sysUser);
        return this.get(sysUser.getId());
    }

    
    /**
    * 更新用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysUser sysUser) {
        Assert.notNull(sysUser,"sysUser不能为空");
        SysUser old = this.get(sysUser.getId());
        if (old == null){
            throw new RuntimeException("用户表信息不存在!");
        }
        sysUser.setVersions(old.getVersions());
        if (StringUtils.isEmpty(sysUser.getUpdater())) {
            sysUser.setUpdater(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysUser.getUpdateTime())) {
            sysUser.setUpdateTime(new Date());
        }
        int count = sysUserMapper.updatex(sysUser);
        if (count == 0){
            throw new RuntimeException("用户表信息更新失败!");
        }
        return count;
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    @Override
    public List<SysUser> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<SysUser> sysUserCond = new Condition<>();
        sysUserCond.createCriteria().andIn(SysUser.ID, ids);
        sysUserCond.limit(Page.getMaxRow());
        return this.listByCondition(sysUserCond);
    }

    
    /**
    * 根据po查询用户表列表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    @Override
    public List<SysUser> list(SysUser sysUser) {
        Assert.notNull(sysUser,"sysUser不能为空");
        return sysUserMapper.listLimitx(sysUser, new LimitCondition(sysUser.getStart(), sysUser.getRow()));
    }

    
    /**
    * 根据po查询用户表总数
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int count(SysUser sysUser) {
        Assert.notNull(sysUser,"sysUser不能为空");
        return sysUserMapper.countx(sysUser);
    }

    
    /**
    * 根据条件类查询用户表列表
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    @Override
    public List<SysUser> listByCondition(Condition<SysUser> sysUserCond) {
        Assert.notNull(sysUserCond,"sysUserCond不能为空");
        return sysUserMapper.listByConditionx(sysUserCond);
    }

    
    /**
    * 根据条件类查询用户表总数
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int countByCondition(Condition<SysUser> sysUserCond) {
        Assert.notNull(sysUserCond,"sysUserCond不能为空");
        return sysUserMapper.countByConditionx(sysUserCond);
    }

    
    /**
    * 
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<SysUser> sysUserCond) {
        List<SysUser> list = this.listByCondition(sysUserCond);
        return list.stream().map(SysUser::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的用户表列表转map
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUser>
    */
    @Override
    public Map<Integer, SysUser> map(Condition<SysUser> sysUserCond) {
        List<SysUser> sysUserList = this.listByCondition(sysUserCond);
        return sysUserList.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));
    }

    
    /**
    * 将符合查询条件的用户表列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUser>
    */
    @Override
    public Map<Integer, SysUser> mapByIds(List<Integer> ids) {
        List<SysUser> sysUserList = this.listByIds(ids);
        return sysUserList.stream().collect(Collectors.toMap(SysUser::getId, Function.identity()));
    }

    
    /**
    * 分批查询用户表
    * @param gtId gtId
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    @Override
    public List<SysUser> batchList(int gtId, Condition<SysUser> sysUserCond) {
        Assert.notNull(sysUserCond,"sysUserCond不能为空");
        sysUserCond.limit(1,Page.getMaxRow() - 1);
        sysUserCond.setOrderBy(SysUser.ID);
        sysUserCond.andCriteria().andGreaterThan(SysUser.ID, gtId);
        return this.listByCondition(sysUserCond);
    }
}