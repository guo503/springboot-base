package com.tsyj.service.impl;

import com.google.common.collect.*;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.SysUserRoleMapper;
import com.tsyj.model.SysUserRole;
import com.tsyj.page.Page;
import com.tsyj.service.SysUserRoleService;
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
* 用户-角色service实现类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRole
    */
    @Override
    public SysUserRole get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return sysUserRoleMapper.getx(id);
    }

    
    /**
    * 根据sysUserRole查询用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRole
    */
    @Override
    public SysUserRole getOne(SysUserRole sysUserRole) {
        Assert.notNull(sysUserRole,"sysUserRole不能为空");
        return sysUserRoleMapper.getOnex(sysUserRole);
    }

    
    /**
    * 新增用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysUserRole sysUserRole) {
        Assert.notNull(sysUserRole,"sysUserRole不能为空");
        if (StringUtils.isEmpty(sysUserRole.getCreator())) {
            sysUserRole.setCreator(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysUserRole.getCreateTime())) {
            sysUserRole.setCreateTime(new Date());
        }
        return sysUserRoleMapper.savex(sysUserRole);
    }

    
    /**
    * 新增并返回用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRole
    */
    @Transactional
    @Override
    public SysUserRole saveAndGet(SysUserRole sysUserRole) {
        this.save(sysUserRole);
        return this.get(sysUserRole.getId());
    }

    
    /**
    * 更新用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysUserRole sysUserRole) {
        Assert.notNull(sysUserRole,"sysUserRole不能为空");
        SysUserRole old = this.get(sysUserRole.getId());
        if (old == null){
            throw new RuntimeException("用户-角色信息不存在!");
        }
        sysUserRole.setVersions(old.getVersions());
        if (StringUtils.isEmpty(sysUserRole.getUpdater())) {
            sysUserRole.setUpdater(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysUserRole.getUpdateTime())) {
            sysUserRole.setUpdateTime(new Date());
        }
        int count = sysUserRoleMapper.updatex(sysUserRole);
        if (count == 0){
            throw new RuntimeException("用户-角色信息更新失败!");
        }
        return count;
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    @Override
    public List<SysUserRole> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        sysUserRoleCond.createCriteria().andIn(SysUserRole.ID, ids);
        sysUserRoleCond.limit(Page.getMaxRow());
        return this.listByCondition(sysUserRoleCond);
    }

    
    /**
    * 根据po查询用户-角色列表
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    @Override
    public List<SysUserRole> list(SysUserRole sysUserRole) {
        Assert.notNull(sysUserRole,"sysUserRole不能为空");
        return sysUserRoleMapper.listLimitx(sysUserRole, new LimitCondition(sysUserRole.getStart(), sysUserRole.getRow()));
    }

    
    /**
    * 根据po查询用户-角色总数
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int count(SysUserRole sysUserRole) {
        Assert.notNull(sysUserRole,"sysUserRole不能为空");
        return sysUserRoleMapper.countx(sysUserRole);
    }

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    @Override
    public List<SysUserRole> listByCondition(Condition<SysUserRole> sysUserRoleCond) {
        Assert.notNull(sysUserRoleCond,"sysUserRoleCond不能为空");
        return sysUserRoleMapper.listByConditionx(sysUserRoleCond);
    }

    
    /**
    * 根据条件类查询用户-角色总数
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int countByCondition(Condition<SysUserRole> sysUserRoleCond) {
        Assert.notNull(sysUserRoleCond,"sysUserRoleCond不能为空");
        return sysUserRoleMapper.countByConditionx(sysUserRoleCond);
    }

    
    /**
    * 
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<SysUserRole> sysUserRoleCond) {
        List<SysUserRole> list = this.listByCondition(sysUserRoleCond);
        return list.stream().map(SysUserRole::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的用户-角色列表转map
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUserRole>
    */
    @Override
    public Map<Integer, SysUserRole> map(Condition<SysUserRole> sysUserRoleCond) {
        List<SysUserRole> sysUserRoleList = this.listByCondition(sysUserRoleCond);
        return sysUserRoleList.stream().collect(Collectors.toMap(SysUserRole::getId, Function.identity()));
    }

    
    /**
    * 将符合查询条件的用户-角色列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUserRole>
    */
    @Override
    public Map<Integer, SysUserRole> mapByIds(List<Integer> ids) {
        List<SysUserRole> sysUserRoleList = this.listByIds(ids);
        return sysUserRoleList.stream().collect(Collectors.toMap(SysUserRole::getId, Function.identity()));
    }

    
    /**
    * 分批查询用户-角色
    * @param gtId gtId
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    @Override
    public List<SysUserRole> batchList(int gtId, Condition<SysUserRole> sysUserRoleCond) {
        Assert.notNull(sysUserRoleCond,"sysUserRoleCond不能为空");
        sysUserRoleCond.limit(1,Page.getMaxRow() - 1);
        sysUserRoleCond.setOrderBy(SysUserRole.ID);
        sysUserRoleCond.andCriteria().andGreaterThan(SysUserRole.ID, gtId);
        return this.listByCondition(sysUserRoleCond);
    }
}