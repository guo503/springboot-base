package com.tsyj.business;

import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import java.util.*;

/**
* 菜单表service类
* @author guos
* @date 2020/07/24 16:57
*/
public interface SysMenuBusiness {
    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysMenuVO
    */
    SysMenuVO get(Integer id);

    
    /**
    * 新增菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int save(SysMenu sysMenu);

    
    /**
    * 更新菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int update(SysMenu sysMenu);

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuQuery sysMenuQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysMenuVO>>
    */
    Result<List<SysMenuVO>> listByCondition(SysMenuQuery sysMenuQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询菜单表总数
    * @param sysMenuQuery sysMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int countByCondition(SysMenuQuery sysMenuQuery);

    
    /**
    * 处理菜单表分批查询
    * @param sysMenuQuery sysMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    void doBatch(SysMenuQuery sysMenuQuery);
}