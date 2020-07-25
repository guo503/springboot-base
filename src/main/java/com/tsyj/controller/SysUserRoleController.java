package com.tsyj.controller;

import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 用户-角色api类
* @author guos
* @date 2020/07/24 16:57
*/
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController extends BaseController {
    
    @Autowired
    private SysUserRoleBusiness sysUserRoleBusiness;

    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<SysUserRoleVO>
    */
    @GetMapping("/{id}")
    public Result<SysUserRoleVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysUserRoleBusiness.get(id));
    }

    
    /**
    * 新增用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysUserRole sysUserRole) {
        return sysUserRoleBusiness.save(sysUserRole) > 0 ? Result.success("用户-角色添加成功"): Result.fail("用户-角色添加失败");
    }

    
    /**
    * 更新用户-角色
    * @param id id
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysUserRole sysUserRole) {
        sysUserRole.setId(id);
        return sysUserRoleBusiness.update(sysUserRole) > 0 ? Result.success("用户-角色更新成功"): Result.fail("用户-角色更新失败");
    }

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleQuery sysUserRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysUserRoleVO>>
    */
    @GetMapping
    public Result<List<SysUserRoleVO>> listByCondition(SysUserRoleQuery sysUserRoleQuery) {
        return sysUserRoleBusiness.listByCondition(sysUserRoleQuery, this.getPageNum(), this.getPageSize());
    }
}