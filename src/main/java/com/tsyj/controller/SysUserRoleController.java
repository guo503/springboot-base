package com.tsyj.controller;

import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserRoleVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 用户-角色api类
* @author guos
* @date 2019/10/31 18:20
*/
@CrossOrigin
@RestController
@RequestMapping("/sys-user-role")
public class SysUserRoleController {
    
    @Autowired
    private SysUserRoleBusiness sysUserRoleBusiness;

    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<SysUserRoleVO>
    */
    @GetMapping("/{id}")
    public Result<SysUserRoleVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysUserRoleBusiness.get(id));
    }

    
    /**
    * 新增用户-角色
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysUserRoleVO sysUserRoleVO) {
        return sysUserRoleBusiness.save(sysUserRoleVO) > 0 ? Result.success("用户-角色添加成功"): Result.fail("用户-角色添加失败");
    }

    
    /**
    * 更新用户-角色
    * @param id id
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysUserRoleVO sysUserRoleVO) {
        sysUserRoleVO.setId(id);
        return sysUserRoleBusiness.update(sysUserRoleVO) > 0 ? Result.success("用户-角色更新成功"): Result.fail("用户-角色更新失败");
    }

    
    /**
    * 根据po查询用户-角色列表
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysUserRoleVO>>
    */
    @GetMapping
    public Result<List<SysUserRoleVO>> list(SysUserRoleVO sysUserRoleVO) {
        return sysUserRoleBusiness.list(sysUserRoleVO);
    }
}