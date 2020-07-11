package com.tsyj.business;

import com.tsyj.ao.SysRoleMenuAO;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;

/**
* 角色-菜单service类
* @author guos
* @date 2020/07/11 17:24
*/
public interface SysRoleMenuBusiness {
    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return SysRoleMenuVO
    */
    SysRoleMenuVO get(Integer id);

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int save(SysRoleMenuAO sysRoleMenuAO);

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int update(SysRoleMenuAO sysRoleMenuAO);

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuAO sysRoleMenuAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysRoleMenuVO>>
    */
    Result<List<SysRoleMenuVO>> listByCondition(SysRoleMenuAO sysRoleMenuAO, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询角色-菜单总数
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int countByCondition(SysRoleMenuAO sysRoleMenuAO);

    
    /**
    * 处理角色-菜单分批查询
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    void doBatch(SysRoleMenuAO sysRoleMenuAO);
}