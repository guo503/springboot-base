package com.tsyj.controller;

import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 用户表api类
* @author guos
* @date 2020/07/24 16:57
*/
@RestController
@RequestMapping("/sys-user")
public class SysUserController extends BaseController {
    
    @Autowired
    private SysUserBusiness sysUserBusiness;

    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<SysUserVO>
    */
    @GetMapping("/{id}")
    public Result<SysUserVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysUserBusiness.get(id));
    }

    
    /**
    * 新增用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysUser sysUser) {
        return sysUserBusiness.save(sysUser) > 0 ? Result.success("用户表添加成功"): Result.fail("用户表添加失败");
    }

    
    /**
    * 更新用户表
    * @param id id
    * @param sysUser sysUser
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysUser sysUser) {
        sysUser.setId(id);
        return sysUserBusiness.update(sysUser) > 0 ? Result.success("用户表更新成功"): Result.fail("用户表更新失败");
    }

    
    /**
    * 根据条件类查询用户表列表
    * @param sysUserQuery sysUserQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysUserVO>>
    */
    @GetMapping
    public Result<List<SysUserVO>> listByCondition(SysUserQuery sysUserQuery) {
        return sysUserBusiness.listByCondition(sysUserQuery, this.getPageNum(), this.getPageSize());
    }
}