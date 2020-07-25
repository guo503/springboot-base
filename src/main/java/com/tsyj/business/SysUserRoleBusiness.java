package com.tsyj.business;

import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;

/**
* 用户-角色service类
* @author guos
* @date 2020/07/24 16:57
*/
public interface SysUserRoleBusiness {
    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysUserRoleVO
    */
    SysUserRoleVO get(Integer id);

    
    /**
    * 新增用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int save(SysUserRole sysUserRole);

    
    /**
    * 更新用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int update(SysUserRole sysUserRole);

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleQuery sysUserRoleQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysUserRoleVO>>
    */
    Result<List<SysUserRoleVO>> listByCondition(SysUserRoleQuery sysUserRoleQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询用户-角色总数
    * @param sysUserRoleQuery sysUserRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int countByCondition(SysUserRoleQuery sysUserRoleQuery);

    
    /**
    * 处理用户-角色分批查询
    * @param sysUserRoleQuery sysUserRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    void doBatch(SysUserRoleQuery sysUserRoleQuery);
}