package com.tsyj.service.impl;

import com.google.common.collect.*;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.SysMenuMapper;
import com.tsyj.model.SysMenu;
import com.tsyj.page.Page;
import com.tsyj.service.SysMenuService;
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
* 菜单表service实现类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysMenuServiceImpl implements SysMenuService {
    
    @Autowired
    private SysMenuMapper sysMenuMapper;

    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenu
    */
    @Override
    public SysMenu get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return sysMenuMapper.getx(id);
    }

    
    /**
    * 根据sysMenu查询菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenu
    */
    @Override
    public SysMenu getOne(SysMenu sysMenu) {
        Assert.notNull(sysMenu,"sysMenu不能为空");
        return sysMenuMapper.getOnex(sysMenu);
    }

    
    /**
    * 新增菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysMenu sysMenu) {
        Assert.notNull(sysMenu,"sysMenu不能为空");
        if (StringUtils.isEmpty(sysMenu.getCreator())) {
            sysMenu.setCreator(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysMenu.getCreateTime())) {
            sysMenu.setCreateTime(new Date());
        }
        return sysMenuMapper.savex(sysMenu);
    }

    
    /**
    * 新增并返回菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenu
    */
    @Transactional
    @Override
    public SysMenu saveAndGet(SysMenu sysMenu) {
        this.save(sysMenu);
        return this.get(sysMenu.getId());
    }

    
    /**
    * 更新菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysMenu sysMenu) {
        Assert.notNull(sysMenu,"sysMenu不能为空");
        SysMenu old = this.get(sysMenu.getId());
        if (old == null){
            throw new RuntimeException("菜单表信息不存在!");
        }
        sysMenu.setVersions(old.getVersions());
        if (StringUtils.isEmpty(sysMenu.getUpdater())) {
            sysMenu.setUpdater(UserConst.DEFAULT_NAME);
        }
        if (StringUtils.isEmpty(sysMenu.getUpdateTime())) {
            sysMenu.setUpdateTime(new Date());
        }
        int count = sysMenuMapper.updatex(sysMenu);
        if (count == 0){
            throw new RuntimeException("菜单表信息更新失败!");
        }
        return count;
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    @Override
    public List<SysMenu> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<SysMenu> sysMenuCond = new Condition<>();
        sysMenuCond.createCriteria().andIn(SysMenu.ID, ids);
        sysMenuCond.limit(Page.getMaxRow());
        return this.listByCondition(sysMenuCond);
    }

    
    /**
    * 根据po查询菜单表列表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    @Override
    public List<SysMenu> list(SysMenu sysMenu) {
        Assert.notNull(sysMenu,"sysMenu不能为空");
        return sysMenuMapper.listLimitx(sysMenu, new LimitCondition(sysMenu.getStart(), sysMenu.getRow()));
    }

    
    /**
    * 根据po查询菜单表总数
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int count(SysMenu sysMenu) {
        Assert.notNull(sysMenu,"sysMenu不能为空");
        return sysMenuMapper.countx(sysMenu);
    }

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    @Override
    public List<SysMenu> listByCondition(Condition<SysMenu> sysMenuCond) {
        Assert.notNull(sysMenuCond,"sysMenuCond不能为空");
        return sysMenuMapper.listByConditionx(sysMenuCond);
    }

    
    /**
    * 根据条件类查询菜单表总数
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    public int countByCondition(Condition<SysMenu> sysMenuCond) {
        Assert.notNull(sysMenuCond,"sysMenuCond不能为空");
        return sysMenuMapper.countByConditionx(sysMenuCond);
    }

    
    /**
    * 
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<SysMenu> sysMenuCond) {
        List<SysMenu> list = this.listByCondition(sysMenuCond);
        return list.stream().map(SysMenu::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的菜单表列表转map
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysMenu>
    */
    @Override
    public Map<Integer, SysMenu> map(Condition<SysMenu> sysMenuCond) {
        List<SysMenu> sysMenuList = this.listByCondition(sysMenuCond);
        return sysMenuList.stream().collect(Collectors.toMap(SysMenu::getId, Function.identity()));
    }

    
    /**
    * 将符合查询条件的菜单表列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysMenu>
    */
    @Override
    public Map<Integer, SysMenu> mapByIds(List<Integer> ids) {
        List<SysMenu> sysMenuList = this.listByIds(ids);
        return sysMenuList.stream().collect(Collectors.toMap(SysMenu::getId, Function.identity()));
    }

    
    /**
    * 分批查询菜单表
    * @param gtId gtId
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    @Override
    public List<SysMenu> batchList(int gtId, Condition<SysMenu> sysMenuCond) {
        Assert.notNull(sysMenuCond,"sysMenuCond不能为空");
        sysMenuCond.limit(1,Page.getMaxRow() - 1);
        sysMenuCond.setOrderBy(SysMenu.ID);
        sysMenuCond.andCriteria().andGreaterThan(SysMenu.ID, gtId);
        return this.listByCondition(sysMenuCond);
    }
}