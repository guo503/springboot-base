package com.tsyj.business;

import com.tsyj.ao.SysRoleAO;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleVO;
import java.util.*;

/**
* 角色表service类
* @author guos
* @date 2020/07/11 17:24
*/
public interface SysRoleBusiness {
    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return SysRoleVO
    */
    SysRoleVO get(Integer id);

    
    /**
    * 新增角色表
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int save(SysRoleAO sysRoleAO);

    
    /**
    * 更新角色表
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int update(SysRoleAO sysRoleAO);

    
    /**
    * 根据条件类查询角色表列表
    * @param sysRoleAO sysRoleAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysRoleVO>>
    */
    Result<List<SysRoleVO>> listByCondition(SysRoleAO sysRoleAO, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询角色表总数
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int countByCondition(SysRoleAO sysRoleAO);

    
    /**
    * 处理角色表分批查询
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    void doBatch(SysRoleAO sysRoleAO);
}