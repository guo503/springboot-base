package com.tsyj.service;

import com.tsyj.model.SysUser;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;

/**
* 用户表service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysUserService {
    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUser
    */
    SysUser get(Integer id);

    
    /**
    * 根据sysUser查询用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUser
    */
    SysUser getOne(SysUser sysUser);

    
    /**
    * 新增用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysUser sysUser);

    
    /**
    * 新增并返回用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUser
    */
    SysUser saveAndGet(SysUser sysUser);

    
    /**
    * 更新用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysUser sysUser);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    List<SysUser> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询用户表列表
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    List<SysUser> list(SysUser sysUser);

    
    /**
    * 根据po查询用户表总数
    * @param sysUser sysUser
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysUser sysUser);

    
    /**
    * 根据条件类查询用户表列表
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    List<SysUser> listByCondition(Condition<SysUser> sysUserCond);

    
    /**
    * 根据条件类查询用户表总数
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int countByCondition(Condition<SysUser> sysUserCond);

    
    /**
    * 
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<Integer>
    */
    List<Integer> listId(Condition<SysUser> sysUserCond);

    
    /**
    * 将符合查询条件的用户表列表转map
    * @param ids ids
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUser>
    */
    Map<Integer, SysUser> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的用户表列表转map
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return Map<Integer, SysUser>
    */
    Map<Integer, SysUser> map(Condition<SysUser> sysUserCond);

    
    /**
    * 分批查询用户表
    * @param gtId gtId
    * @param sysUserCond sysUserCond
    * @author guos
    * @date 2019/10/31 18:20
    * @return List<SysUser>
    */
    List<SysUser> batchList(int gtId, Condition<SysUser> sysUserCond);
}