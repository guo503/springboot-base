package com.tsyj.service;

import com.tsyj.model.SysRole;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;

/**
* 角色表service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysRoleService {
    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRole
    */
    SysRole get(Integer id);

    
    /**
    * 根据sysRole查询角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRole
    */
    SysRole getOne(SysRole sysRole);

    
    /**
    * 新增角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysRole sysRole);

    
    /**
    * 新增并返回角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRole
    */
    SysRole saveAndGet(SysRole sysRole);

    
    /**
    * 更新角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysRole sysRole);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    List<SysRole> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询角色表列表
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    List<SysRole> list(SysRole sysRole);

    
    /**
    * 根据po查询角色表总数
    * @param sysRole sysRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysRole sysRole);

    
    /**
    * 根据条件类查询角色表列表
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    List<SysRole> listByCondition(Condition<SysRole> sysRoleCond);

    
    /**
    * 根据条件类查询角色表总数
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int countByCondition(Condition<SysRole> sysRoleCond);

    
    /**
    * 
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    List<Integer> listId(Condition<SysRole> sysRoleCond);

    
    /**
    * 将符合查询条件的角色表列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRole>
    */
    Map<Integer, SysRole> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的角色表列表转map
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysRole>
    */
    Map<Integer, SysRole> map(Condition<SysRole> sysRoleCond);

    
    /**
    * 分批查询角色表
    * @param gtId gtId
    * @param sysRoleCond sysRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysRole>
    */
    List<SysRole> batchList(int gtId, Condition<SysRole> sysRoleCond);
}