package com.tsyj.controller;

import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 角色-菜单api类
* @author guos
* @date 2020/07/24 16:57
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
    * @date 2020/07/24 16:57
    * @return Result<SysRoleMenuVO>
    */
    @GetMapping("/{id}")
    public Result<SysRoleMenuVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysRoleMenuBusiness.get(id));
    }

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysRoleMenu sysRoleMenu) {
        return sysRoleMenuBusiness.save(sysRoleMenu) > 0 ? Result.success("角色-菜单添加成功"): Result.fail("角色-菜单添加失败");
    }

    
    /**
    * 更新角色-菜单
    * @param id id
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenu.setId(id);
        return sysRoleMenuBusiness.update(sysRoleMenu) > 0 ? Result.success("角色-菜单更新成功"): Result.fail("角色-菜单更新失败");
    }

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysRoleMenuVO>>
    */
    @GetMapping
    public Result<List<SysRoleMenuVO>> listByCondition(SysRoleMenuQuery sysRoleMenuQuery) {
        return sysRoleMenuBusiness.listByCondition(sysRoleMenuQuery, this.getPageNum(), this.getPageSize());
    }
}