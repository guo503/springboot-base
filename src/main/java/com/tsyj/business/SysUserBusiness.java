package com.tsyj.business;

import com.tsyj.ao.SysUserAO;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserVO;
import java.util.*;

/**
* 用户表service类
* @author guos
* @date 2020/07/11 17:24
*/
public interface SysUserBusiness {
    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return SysUserVO
    */
    SysUserVO get(Integer id);

    
    /**
    * 新增用户表
    * @param sysUserAO sysUserAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int save(SysUserAO sysUserAO);

    
    /**
    * 更新用户表
    * @param sysUserAO sysUserAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int update(SysUserAO sysUserAO);

    
    /**
    * 根据条件类查询用户表列表
    * @param sysUserAO sysUserAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysUserVO>>
    */
    Result<List<SysUserVO>> listByCondition(SysUserAO sysUserAO, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询用户表总数
    * @param sysUserAO sysUserAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    int countByCondition(SysUserAO sysUserAO);

    
    /**
    * 处理用户表分批查询
    * @param sysUserAO sysUserAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    void doBatch(SysUserAO sysUserAO);
}