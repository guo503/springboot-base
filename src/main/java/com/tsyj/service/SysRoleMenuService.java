package com.tsyj.service;

import com.tsyj.model.SysRoleMenu;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;

/**
* 角色-菜单service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysRoleMenuService {
    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenu
    */
    SysRoleMenu get(Integer id);

    
    /**
    * 根据sysRoleMenu查询角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenu
    */
    SysRoleMenu getOne(SysRoleMenu sysRoleMenu);

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysRoleMenu sysRoleMenu);

    
    /**
    * 新增并返回角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenu
    */
    SysRoleMenu saveAndGet(SysRoleMenu sysRoleMenu);

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysRoleMenu sysRoleMenu);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    List<SysRoleMenu> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询角色-菜单列表
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    List<SysRoleMenu> list(SysRoleMenu sysRoleMenu);

    
    /**
    * 根据po查询角色-菜单总数
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysRoleMenu sysRoleMenu);

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    List<SysRoleMenu> listByCondition(Condition<SysRoleMenu> sysRoleMenuCond);

    
    /**
    * 根据条件类查询角色-菜单总数
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int countByCondition(Condition<SysRoleMenu> sysRoleMenuCond);

    
    /**
    * 
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    List<Integer> listId(Condition<SysRoleMenu> sysRoleMenuCond);

    
    /**
    * 将符合查询条件的角色-菜单列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRoleMenu>
    */
    Map<Integer, SysRoleMenu> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的角色-菜单列表转map
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRoleMenu>
    */
    Map<Integer, SysRoleMenu> map(Condition<SysRoleMenu> sysRoleMenuCond);

    
    /**
    * 分批查询角色-菜单
    * @param gtId gtId
    * @param sysRoleMenuCond sysRoleMenuCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRoleMenu>
    */
    List<SysRoleMenu> batchList(int gtId, Condition<SysRoleMenu> sysRoleMenuCond);
}