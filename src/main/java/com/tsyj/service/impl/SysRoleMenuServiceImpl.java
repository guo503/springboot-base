package com.tsyj.service.impl;

import com.google.common.collect.*;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.SysRoleMenuMapper;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.page.Page;
import com.tsyj.service.SysRoleMenuService;
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
* 角色-菜单service实现类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenu
    */
    @Override
    public SysRoleMenu get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return sysRoleMenuMapper.getx(id);
    }

    
    /**
    * 根据sysRoleMenu查询角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenu
    */
    @Override
    public SysRoleMenu getOne(SysRoleMenu sysRoleMenu) {
        Assert.notNull(sysRoleMenu,"sysRoleMenu不能为空");
        return sysRoleMenuMapper.getOnex(sysRoleMenu);
    }

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysRoleMenu sysRoleMenu) {
        Assert.notNull(sysRoleMenu,"sysRoleMenu不能为空");
        if (StringUtils.isEmpty(sysRoleMenu.getCreator())) {
            sysRoleMenu.setCreator(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysRoleMenu.getCreateTime())) {
            sysRoleMenu.setCreateTime(new Date());
        }
        return sysRoleMenuMapper.savex(sysRoleMenu);
    }

    
    /**
    * 新增并返回角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenu
    */
    @Transactional
    @Override
    public SysRoleMenu saveAndGet(SysRoleMenu sysRoleMenu) {
        this.save(sysRoleMenu);
        return this.get(sysRoleMenu.getId());
    }

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysRoleMenu sysRoleMenu) {
        Assert.notNull(sysRoleMenu,"sysRoleMenu不能为空");
        SysRoleMenu old = this.get(sysRoleMenu.getId());
        if (old == null){
            throw new RuntimeException("角色-菜单信息不存在!");
        }
        sysRoleMenu.setVersions(old.getVersions());
        if (StringUtils.isEmpty(sysRoleMenu.getUpdater())) {
            sysRoleMenu.setUpdater(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysRoleMenu.getUpdateTime())) {
            sysRoleMenu.setUpdateTime(new Date());
        }
        int count = sysRoleMenuMapper.updatex(sysRoleMenu);
        if (count == 0){
            throw new RuntimeException("角色-菜单信息更新失败!");
        }
        return count;
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    @Override
    public List<SysRoleMenu> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        sysRoleMenuCond.createCriteria().andIn(SysRoleMenu.ID, ids);
        sysRoleMenuCond.limit(Page.getMaxRow());
        return this.listByCondition(sysRoleMenuCond);
    }

    
    /**
    * 根据po查询角色-菜单列表
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    @Override
    public List<SysRoleMenu> list(SysRoleMenu sysRoleMenu) {
        Assert.notNull(sysRoleMenu,"sysRoleMenu不能为空");
        return sysRoleMenuMapper.listLimitx(sysRoleMenu, new LimitCondition(sysRoleMenu.getStart(), sysRoleMenu.getRow()));
    }

    
    /**
    * 根据po查询角色-菜单总数
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int count(SysRoleMenu sysRoleMenu) {
        Assert.notNull(sysRoleMenu,"sysRoleMenu不能为空");
        return sysRoleMenuMapper.countx(sysRoleMenu);
    }

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    @Override
    public List<SysRoleMenu> listByCondition(Condition<SysRoleMenu> sysRoleMenuCond) {
        Assert.notNull(sysRoleMenuCond,"sysRoleMenuCond不能为空");
        return sysRoleMenuMapper.listByConditionx(sysRoleMenuCond);
    }

    
    /**
    * 根据条件类查询角色-菜单总数
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int countByCondition(Condition<SysRoleMenu> sysRoleMenuCond) {
        Assert.notNull(sysRoleMenuCond,"sysRoleMenuCond不能为空");
        return sysRoleMenuMapper.countByConditionx(sysRoleMenuCond);
    }

    
    /**
    * 
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<SysRoleMenu> sysRoleMenuCond) {
        List<SysRoleMenu> list = this.listByCondition(sysRoleMenuCond);
        return list.stream().map(SysRoleMenu::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的角色-菜单列表转map
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRoleMenu>
    */
    @Override
    public Map<Integer, SysRoleMenu> map(Condition<SysRoleMenu> sysRoleMenuCond) {
        List<SysRoleMenu> sysRoleMenuList = this.listByCondition(sysRoleMenuCond);
        return sysRoleMenuList.stream().collect(Collectors.toMap(SysRoleMenu::getId, Function.identity()));
    }

    
    /**
    * 将符合查询条件的角色-菜单列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRoleMenu>
    */
    @Override
    public Map<Integer, SysRoleMenu> mapByIds(List<Integer> ids) {
        List<SysRoleMenu> sysRoleMenuList = this.listByIds(ids);
        return sysRoleMenuList.stream().collect(Collectors.toMap(SysRoleMenu::getId, Function.identity()));
    }

    
    /**
    * 分批查询角色-菜单
    * @param gtId gtId
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    @Override
    public List<SysRoleMenu> batchList(int gtId, Condition<SysRoleMenu> sysRoleMenuCond) {
        Assert.notNull(sysRoleMenuCond,"sysRoleMenuCond不能为空");
        sysRoleMenuCond.limit(1,Page.getMaxRow() - 1);
        sysRoleMenuCond.setOrderBy(SysRoleMenu.ID);
        sysRoleMenuCond.andCriteria().andGreaterThan(SysRoleMenu.ID, gtId);
        return this.listByCondition(sysRoleMenuCond);
    }
}