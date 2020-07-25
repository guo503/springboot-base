package com.tsyj.business;

import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserVO;
import java.util.*;

/**
* 用户表service类
* @author guos
* @date 2020/07/24 16:57
*/
public interface SysUserBusiness {
    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysUserVO
    */
    SysUserVO get(Integer id);

    
    /**
    * 新增用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int save(SysUser sysUser);

    
    /**
    * 更新用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int update(SysUser sysUser);

    
    /**
    * 根据条件类查询用户表列表
    * @param sysUserQuery sysUserQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysUserVO>>
    */
    Result<List<SysUserVO>> listByCondition(SysUserQuery sysUserQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询用户表总数
    * @param sysUserQuery sysUserQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    int countByCondition(SysUserQuery sysUserQuery);

    
    /**
    * 处理用户表分批查询
    * @param sysUserQuery sysUserQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    void doBatch(SysUserQuery sysUserQuery);
}