package com.tsyj.business;

import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleVO;
import java.util.*;

/**
* 角色表service类
* @author guos
* @date 2020/07/24 16:57
*/
public interface SysRoleBusiness {
    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysRoleVO
    */
    SysRoleVO get(Integer id);

    
    /**
    * 新增角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int save(SysRole sysRole);

    
    /**
    * 更新角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int update(SysRole sysRole);

    
    /**
    * 根据条件类查询角色表列表
    * @param sysRoleQuery sysRoleQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysRoleVO>>
    */
    Result<List<SysRoleVO>> listByCondition(SysRoleQuery sysRoleQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询角色表总数
    * @param sysRoleQuery sysRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int countByCondition(SysRoleQuery sysRoleQuery);

    
    /**
    * 处理角色表分批查询
    * @param sysRoleQuery sysRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    void doBatch(SysRoleQuery sysRoleQuery);
}