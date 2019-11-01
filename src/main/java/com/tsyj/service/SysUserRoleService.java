package com.tsyj.service;

import com.tsyj.model.SysUserRole;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;

/**
* 用户-角色service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysUserRoleService {
    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRole
    */
    SysUserRole get(Integer id);

    
    /**
    * 根据sysUserRole查询用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRole
    */
    SysUserRole getOne(SysUserRole sysUserRole);

    
    /**
    * 新增用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysUserRole sysUserRole);

    
    /**
    * 新增并返回用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRole
    */
    SysUserRole saveAndGet(SysUserRole sysUserRole);

    
    /**
    * 更新用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysUserRole sysUserRole);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    List<SysUserRole> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询用户-角色列表
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    List<SysUserRole> list(SysUserRole sysUserRole);

    
    /**
    * 根据po查询用户-角色总数
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysUserRole sysUserRole);

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    List<SysUserRole> listByCondition(Condition<SysUserRole> sysUserRoleCond);

    
    /**
    * 根据条件类查询用户-角色总数
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int countByCondition(Condition<SysUserRole> sysUserRoleCond);

    
    /**
    * 
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    List<Integer> listId(Condition<SysUserRole> sysUserRoleCond);

    
    /**
    * 将符合查询条件的用户-角色列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUserRole>
    */
    Map<Integer, SysUserRole> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的用户-角色列表转map
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUserRole>
    */
    Map<Integer, SysUserRole> map(Condition<SysUserRole> sysUserRoleCond);

    
    /**
    * 分批查询用户-角色
    * @param gtId gtId
    * @param sysUserRoleCond sysUserRoleCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUserRole>
    */
    List<SysUserRole> batchList(int gtId, Condition<SysUserRole> sysUserRoleCond);
}