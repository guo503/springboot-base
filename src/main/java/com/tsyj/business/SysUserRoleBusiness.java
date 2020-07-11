package com.tsyj.business;

import com.tsyj.ao.SysUserRoleAO;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;

/**
* 用户-角色service类
* @author guos
* @date 2020/07/11 17:24
*/
public interface SysUserRoleBusiness {
    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return SysUserRoleVO
    */
    SysUserRoleVO get(Integer id);

    
    /**
    * 新增用户-角色
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int save(SysUserRoleAO sysUserRoleAO);

    
    /**
    * 更新用户-角色
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int update(SysUserRoleAO sysUserRoleAO);

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleAO sysUserRoleAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysUserRoleVO>>
    */
    Result<List<SysUserRoleVO>> listByCondition(SysUserRoleAO sysUserRoleAO, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询用户-角色总数
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int countByCondition(SysUserRoleAO sysUserRoleAO);

    
    /**
    * 处理用户-角色分批查询
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    void doBatch(SysUserRoleAO sysUserRoleAO);
}