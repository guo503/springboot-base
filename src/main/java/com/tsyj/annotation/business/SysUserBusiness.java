package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.SysUserVO;
import java.util.*;

/**
* 用户表service类
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysUserBusiness {
    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserVO
    */
    SysUserVO get(Integer id);

    
    /**
    * 新增用户表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int save(SysUserVO sysUserVO);

    
    /**
    * 更新用户表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int update(SysUserVO sysUserVO);

    
    /**
    * 根据po查询用户表列表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysUserVO>>
    */
    Result<List<SysUserVO>> list(SysUserVO sysUserVO);

    
    /**
    * 根据po查询用户表总数
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    int count(SysUserVO sysUserVO);

    
    /**
    * 处理用户表分批查询
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    void doBatch(SysUserVO sysUserVO);
}