package com.tsyj.controller;

import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.query.SysRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 角色表api类
* @author guos
* @date 2020/07/24 16:57
*/
@RestController
@RequestMapping("/sys-role")
public class SysRoleController extends BaseController {
    
    @Autowired
    private SysRoleBusiness sysRoleBusiness;

    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<SysRoleVO>
    */
    @GetMapping("/{id}")
    public Result<SysRoleVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysRoleBusiness.get(id));
    }

    
    /**
    * 新增角色表
    * @param sysRole sysRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysRole sysRole) {
        return sysRoleBusiness.save(sysRole) > 0 ? Result.success("角色表添加成功"): Result.fail("角色表添加失败");
    }

    
    /**
    * 更新角色表
    * @param id id
    * @param sysRole sysRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysRole sysRole) {
        sysRole.setId(id);
        return sysRoleBusiness.update(sysRole) > 0 ? Result.success("角色表更新成功"): Result.fail("角色表更新失败");
    }

    
    /**
    * 根据条件类查询角色表列表
    * @param sysRoleQuery sysRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysRoleVO>>
    */
    @GetMapping
    public Result<List<SysRoleVO>> listByCondition(SysRoleQuery sysRoleQuery) {
        return sysRoleBusiness.listByCondition(sysRoleQuery, this.getPageNum(), this.getPageSize());
    }
}