package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleVO;
import java.util.*;

/**
* 角色表service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysRoleBusiness {
    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleVO
    */
    SysRoleVO get(Integer id);

    
    /**
    * 新增角色表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysRoleVO sysRoleVO);

    
    /**
    * 更新角色表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysRoleVO sysRoleVO);

    
    /**
    * 根据po查询角色表列表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysRoleVO>>
    */
    Result<List<SysRoleVO>> list(SysRoleVO sysRoleVO);

    
    /**
    * 根据po查询角色表总数
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysRoleVO sysRoleVO);

    
    /**
    * 处理角色表分批查询
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    void doBatch(SysRoleVO sysRoleVO);
}