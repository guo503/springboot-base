package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;

/**
* 用户-角色service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysUserRoleBusiness {
    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRoleVO
    */
    SysUserRoleVO get(Integer id);

    
    /**
    * 新增用户-角色
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysUserRoleVO sysUserRoleVO);

    
    /**
    * 更新用户-角色
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysUserRoleVO sysUserRoleVO);

    
    /**
    * 根据po查询用户-角色列表
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysUserRoleVO>>
    */
    Result<List<SysUserRoleVO>> list(SysUserRoleVO sysUserRoleVO);

    
    /**
    * 根据po查询用户-角色总数
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysUserRoleVO sysUserRoleVO);

    
    /**
    * 处理用户-角色分批查询
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    void doBatch(SysUserRoleVO sysUserRoleVO);
}