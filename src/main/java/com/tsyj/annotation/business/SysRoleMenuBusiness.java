package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;

/**
* 角色-菜单service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysRoleMenuBusiness {
    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleMenuVO
    */
    SysRoleMenuVO get(Integer id);

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysRoleMenuVO sysRoleMenuVO);

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysRoleMenuVO sysRoleMenuVO);

    
    /**
    * 根据po查询角色-菜单列表
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysRoleMenuVO>>
    */
    Result<List<SysRoleMenuVO>> list(SysRoleMenuVO sysRoleMenuVO);

    
    /**
    * 根据po查询角色-菜单总数
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysRoleMenuVO sysRoleMenuVO);

    
    /**
    * 处理角色-菜单分批查询
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    void doBatch(SysRoleMenuVO sysRoleMenuVO);
}