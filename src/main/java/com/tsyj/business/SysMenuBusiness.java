package com.tsyj.business;

import com.tsyj.ao.SysMenuAO;
import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import java.util.*;

/**
* 菜单表service类
* @author guos
* @date 2020/07/11 17:24
*/
public interface SysMenuBusiness {
    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return SysMenuVO
    */
    SysMenuVO get(Integer id);

    
    /**
    * 新增菜单表
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int save(SysMenuAO sysMenuAO);

    
    /**
    * 更新菜单表
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int update(SysMenuAO sysMenuAO);

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuAO sysMenuAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysMenuVO>>
    */
    Result<List<SysMenuVO>> listByCondition(SysMenuAO sysMenuAO, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询菜单表总数
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int countByCondition(SysMenuAO sysMenuAO);

    
    /**
    * 处理菜单表分批查询
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    void doBatch(SysMenuAO sysMenuAO);
}