package com.tsyj.controller;

import com.tsyj.ao.SysUserRoleAO;
import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 用户-角色api类
* @author guos
* @date 2020/07/11 17:24
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
    * @date 2020/07/11 17:24
    * @return Result<SysUserRoleVO>
    */
    @GetMapping("/{id}")
    public Result<SysUserRoleVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysUserRoleBusiness.get(id));
    }

    
    /**
    * 新增用户-角色
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysUserRoleAO sysUserRoleAO) {
        return sysUserRoleBusiness.save(sysUserRoleAO) > 0 ? Result.success("用户-角色添加成功"): Result.fail("用户-角色添加失败");
    }

    
    /**
    * 更新用户-角色
    * @param id id
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysUserRoleAO sysUserRoleAO) {
        sysUserRoleAO.setId(id);
        return sysUserRoleBusiness.update(sysUserRoleAO) > 0 ? Result.success("用户-角色更新成功"): Result.fail("用户-角色更新失败");
    }

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysUserRoleVO>>
    */
    @GetMapping
    public Result<List<SysUserRoleVO>> listByCondition(SysUserRoleAO sysUserRoleAO) {
        return sysUserRoleBusiness.listByCondition(sysUserRoleAO, this.getPageNum(), this.getPageSize());
    }
}