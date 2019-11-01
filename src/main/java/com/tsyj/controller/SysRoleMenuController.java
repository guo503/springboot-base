package com.tsyj.controller;

import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 角色-菜单api类
* @author guos
* @date 2019/10/31 18:20
*/
@CrossOrigin
@RestController
@RequestMapping("/sys-role-menu")
public class SysRoleMenuController {
    
    @Autowired
    private SysRoleMenuBusiness sysRoleMenuBusiness;

    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<SysRoleMenuVO>
    */
    @GetMapping("/{id}")
    public Result<SysRoleMenuVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysRoleMenuBusiness.get(id));
    }

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysRoleMenuVO sysRoleMenuVO) {
        return sysRoleMenuBusiness.save(sysRoleMenuVO) > 0 ? Result.success("角色-菜单添加成功"): Result.fail("角色-菜单添加失败");
    }

    
    /**
    * 更新角色-菜单
    * @param id id
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysRoleMenuVO sysRoleMenuVO) {
        sysRoleMenuVO.setId(id);
        return sysRoleMenuBusiness.update(sysRoleMenuVO) > 0 ? Result.success("角色-菜单更新成功"): Result.fail("角色-菜单更新失败");
    }

    
    /**
    * 根据po查询角色-菜单列表
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysRoleMenuVO>>
    */
    @GetMapping
    public Result<List<SysRoleMenuVO>> list(SysRoleMenuVO sysRoleMenuVO) {
        return sysRoleMenuBusiness.list(sysRoleMenuVO);
    }
}