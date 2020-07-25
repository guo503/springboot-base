package com.tsyj.business;

import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;

/**
* 角色-菜单service类
* @author guos
* @date 2020/07/24 16:57
*/
public interface SysRoleMenuBusiness {
    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysRoleMenuVO
    */
    SysRoleMenuVO get(Integer id);

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int save(SysRoleMenu sysRoleMenu);

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int update(SysRoleMenu sysRoleMenu);

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysRoleMenuVO>>
    */
    Result<List<SysRoleMenuVO>> listByCondition(SysRoleMenuQuery sysRoleMenuQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询角色-菜单总数
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int countByCondition(SysRoleMenuQuery sysRoleMenuQuery);

    
    /**
    * 处理角色-菜单分批查询
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    void doBatch(SysRoleMenuQuery sysRoleMenuQuery);
}