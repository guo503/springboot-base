package com.tsyj.controller;

import com.tsyj.business.SysRoleBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysRoleVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 角色表api类
* @author guos
* @date 2019/10/31 18:20
*/
@CrossOrigin
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {
    
    @Autowired
    private SysRoleBusiness sysRoleBusiness;

    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<SysRoleVO>
    */
    @GetMapping("/{id}")
    public Result<SysRoleVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysRoleBusiness.get(id));
    }

    
    /**
    * 新增角色表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysRoleVO sysRoleVO) {
        return sysRoleBusiness.save(sysRoleVO) > 0 ? Result.success("角色表添加成功"): Result.fail("角色表添加失败");
    }

    
    /**
    * 更新角色表
    * @param id id
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysRoleVO sysRoleVO) {
        sysRoleVO.setId(id);
        return sysRoleBusiness.update(sysRoleVO) > 0 ? Result.success("角色表更新成功"): Result.fail("角色表更新失败");
    }

    
    /**
    * 根据po查询角色表列表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysRoleVO>>
    */
    @GetMapping
    public Result<List<SysRoleVO>> list(SysRoleVO sysRoleVO) {
        return sysRoleBusiness.list(sysRoleVO);
    }
}