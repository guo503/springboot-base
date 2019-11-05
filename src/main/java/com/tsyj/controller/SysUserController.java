package com.tsyj.controller;

import com.tsyj.annotation.NotEmpty;
import com.tsyj.business.SysUserBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 用户表api类
* @author guos
* @date 2019/10/31 18:20
*/
@CrossOrigin
@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    
    @Autowired
    private SysUserBusiness sysUserBusiness;

    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<SysUserVO>
    */
    @GetMapping("/{id}")
    public Result<SysUserVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysUserBusiness.get(id));
    }

    
    /**
    * 新增用户表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PostMapping
    @NotEmpty({"loginName","password","name","phone"})
    public Result<Object> save(@RequestBody SysUserVO sysUserVO) {
        return sysUserBusiness.save(sysUserVO) > 0 ? Result.success("用户表添加成功"): Result.fail("用户表添加失败");
    }

    
    /**
    * 更新用户表
    * @param id id
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    @NotEmpty({"loginName","password","name","phone"})
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysUserVO sysUserVO) {
        sysUserVO.setId(id);
        return sysUserBusiness.update(sysUserVO) > 0 ? Result.success("用户表更新成功"): Result.fail("用户表更新失败");
    }

    
    /**
    * 根据po查询用户表列表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysUserVO>>
    */
    @GetMapping
    @RequiresPermissions("sys:user:view")
    public Result<List<SysUserVO>> list(SysUserVO sysUserVO) {
        return sysUserBusiness.list(sysUserVO);
    }
}