package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import java.util.*;

/**
* 菜单表service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysMenuBusiness {
    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysMenuVO
    */
    SysMenuVO get(Integer id);

    
    /**
    * 新增菜单表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysMenuVO sysMenuVO);

    
    /**
    * 更新菜单表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysMenuVO sysMenuVO);

    
    /**
    * 根据po查询菜单表列表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysMenuVO>>
    */
    Result<List<SysMenuVO>> list(SysMenuVO sysMenuVO);

    
    /**
    * 根据po查询菜单表总数
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysMenuVO sysMenuVO);

    
    /**
    * 处理菜单表分批查询
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    void doBatch(SysMenuVO sysMenuVO);
}