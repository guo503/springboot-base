package com.tsyj.controller;

import com.tsyj.ao.SysRoleMenuAO;
import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 角色-菜单api类
* @author guos
* @date 2020/07/11 17:24
*/
@RestController
@RequestMapping("/sys-role-menu")
public class SysRoleMenuController extends BaseController {
    
    @Autowired
    private SysRoleMenuBusiness sysRoleMenuBusiness;

    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<SysRoleMenuVO>
    */
    @GetMapping("/{id}")
    public Result<SysRoleMenuVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysRoleMenuBusiness.get(id));
    }

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysRoleMenuAO sysRoleMenuAO) {
        return sysRoleMenuBusiness.save(sysRoleMenuAO) > 0 ? Result.success("角色-菜单添加成功"): Result.fail("角色-菜单添加失败");
    }

    
    /**
    * 更新角色-菜单
    * @param id id
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysRoleMenuAO sysRoleMenuAO) {
        sysRoleMenuAO.setId(id);
        return sysRoleMenuBusiness.update(sysRoleMenuAO) > 0 ? Result.success("角色-菜单更新成功"): Result.fail("角色-菜单更新失败");
    }

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuAO sysRoleMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysRoleMenuVO>>
    */
    @GetMapping
    public Result<List<SysRoleMenuVO>> listByCondition(SysRoleMenuAO sysRoleMenuAO) {
        return sysRoleMenuBusiness.listByCondition(sysRoleMenuAO, this.getPageNum(), this.getPageSize());
    }
}