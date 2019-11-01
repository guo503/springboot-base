package com.tsyj.service.impl;

import com.google.common.collect.*;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.SysRoleMapper;
import com.tsyj.model.SysRole;
import com.tsyj.page.Page;
import com.tsyj.service.SysRoleService;
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
* 角色表service实现类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    
    @Autowired
    private SysRoleMapper sysRoleMapper;

    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRole
    */
    @Override
    public SysRole get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return sysRoleMapper.getx(id);
    }

    
    /**
    * 根据sysRole查询角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRole
    */
    @Override
    public SysRole getOne(SysRole sysRole) {
        Assert.notNull(sysRole,"sysRole不能为空");
        return sysRoleMapper.getOnex(sysRole);
    }

    
    /**
    * 新增角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysRole sysRole) {
        Assert.notNull(sysRole,"sysRole不能为空");
        if (StringUtils.isEmpty(sysRole.getCreator())) {
            sysRole.setCreator(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysRole.getCreateTime())) {
            sysRole.setCreateTime(new Date());
        }
        return sysRoleMapper.savex(sysRole);
    }

    
    /**
    * 新增并返回角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRole
    */
    @Transactional
    @Override
    public SysRole saveAndGet(SysRole sysRole) {
        this.save(sysRole);
        return this.get(sysRole.getId());
    }

    
    /**
    * 更新角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysRole sysRole) {
        Assert.notNull(sysRole,"sysRole不能为空");
        SysRole old = this.get(sysRole.getId());
        if (old == null){
            throw new RuntimeException("角色表信息不存在!");
        }
        sysRole.setVersions(old.getVersions());
        if (StringUtils.isEmpty(sysRole.getUpdater())) {
            sysRole.setUpdater(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysRole.getUpdateTime())) {
            sysRole.setUpdateTime(new Date());
        }
        int count = sysRoleMapper.updatex(sysRole);
        if (count == 0){
            throw new RuntimeException("角色表信息更新失败!");
        }
        return count;
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    @Override
    public List<SysRole> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<SysRole> sysRoleCond = new Condition<>();
        sysRoleCond.createCriteria().andIn(SysRole.ID, ids);
        sysRoleCond.limit(Page.getMaxRow());
        return this.listByCondition(sysRoleCond);
    }

    
    /**
    * 根据po查询角色表列表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    @Override
    public List<SysRole> list(SysRole sysRole) {
        Assert.notNull(sysRole,"sysRole不能为空");
        return sysRoleMapper.listLimitx(sysRole, new LimitCondition(sysRole.getStart(), sysRole.getRow()));
    }

    
    /**
    * 根据po查询角色表总数
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int count(SysRole sysRole) {
        Assert.notNull(sysRole,"sysRole不能为空");
        return sysRoleMapper.countx(sysRole);
    }

    
    /**
    * 根据条件类查询角色表列表
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    @Override
    public List<SysRole> listByCondition(Condition<SysRole> sysRoleCond) {
        Assert.notNull(sysRoleCond,"sysRoleCond不能为空");
        return sysRoleMapper.listByConditionx(sysRoleCond);
    }

    
    /**
    * 根据条件类查询角色表总数
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int countByCondition(Condition<SysRole> sysRoleCond) {
        Assert.notNull(sysRoleCond,"sysRoleCond不能为空");
        return sysRoleMapper.countByConditionx(sysRoleCond);
    }

    
    /**
    * 
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<SysRole> sysRoleCond) {
        List<SysRole> list = this.listByCondition(sysRoleCond);
        return list.stream().map(SysRole::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的角色表列表转map
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRole>
    */
    @Override
    public Map<Integer, SysRole> map(Condition<SysRole> sysRoleCond) {
        List<SysRole> sysRoleList = this.listByCondition(sysRoleCond);
        return sysRoleList.stream().collect(Collectors.toMap(SysRole::getId, Function.identity()));
    }

    
    /**
    * 将符合查询条件的角色表列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRole>
    */
    @Override
    public Map<Integer, SysRole> mapByIds(List<Integer> ids) {
        List<SysRole> sysRoleList = this.listByIds(ids);
        return sysRoleList.stream().collect(Collectors.toMap(SysRole::getId, Function.identity()));
    }

    
    /**
    * 分批查询角色表
    * @param gtId gtId
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    @Override
    public List<SysRole> batchList(int gtId, Condition<SysRole> sysRoleCond) {
        Assert.notNull(sysRoleCond,"sysRoleCond不能为空");
        sysRoleCond.limit(1,Page.getMaxRow() - 1);
        sysRoleCond.setOrderBy(SysRole.ID);
        sysRoleCond.andCriteria().andGreaterThan(SysRole.ID, gtId);
        return this.listByCondition(sysRoleCond);
    }
}