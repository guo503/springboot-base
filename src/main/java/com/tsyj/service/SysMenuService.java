package com.tsyj.service;

import com.tsyj.model.SysMenu;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;

/**
* 菜单表service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysMenuService {
    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenu
    */
    SysMenu get(Integer id);

    
    /**
    * 根据sysMenu查询菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenu
    */
    SysMenu getOne(SysMenu sysMenu);

    
    /**
    * 新增菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysMenu sysMenu);

    
    /**
    * 新增并返回菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenu
    */
    SysMenu saveAndGet(SysMenu sysMenu);

    
    /**
    * 更新菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysMenu sysMenu);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    List<SysMenu> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询菜单表列表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    List<SysMenu> list(SysMenu sysMenu);

    
    /**
    * 根据po查询菜单表总数
    * @param sysMenu sysMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysMenu sysMenu);

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    List<SysMenu> listByCondition(Condition<SysMenu> sysMenuCond);

    
    /**
    * 根据条件类查询菜单表总数
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int countByCondition(Condition<SysMenu> sysMenuCond);

    
    /**
    * 
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    List<Integer> listId(Condition<SysMenu> sysMenuCond);

    
    /**
    * 将符合查询条件的菜单表列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysMenu>
    */
    Map<Integer, SysMenu> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的菜单表列表转map
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysMenu>
    */
    Map<Integer, SysMenu> map(Condition<SysMenu> sysMenuCond);

    
    /**
    * 分批查询菜单表
    * @param gtId gtId
    * @param sysMenuCond sysMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysMenu>
    */
    List<SysMenu> batchList(int gtId, Condition<SysMenu> sysMenuCond);
}