package com.tsyj.controller;

import com.tsyj.ao.SysMenuAO;
import com.tsyj.business.SysMenuBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 菜单表api类
* @author guos
* @date 2020/07/11 17:24
*/
@RestController
@RequestMapping("/sys-menu")
public class SysMenuController extends BaseController {
    
    @Autowired
    private SysMenuBusiness sysMenuBusiness;

    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<SysMenuVO>
    */
    @GetMapping("/{id}")
    public Result<SysMenuVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysMenuBusiness.get(id));
    }

    
    /**
    * 新增菜单表
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysMenuAO sysMenuAO) {
        return sysMenuBusiness.save(sysMenuAO) > 0 ? Result.success("菜单表添加成功"): Result.fail("菜单表添加失败");
    }

    
    /**
    * 更新菜单表
    * @param id id
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysMenuAO sysMenuAO) {
        sysMenuAO.setId(id);
        return sysMenuBusiness.update(sysMenuAO) > 0 ? Result.success("菜单表更新成功"): Result.fail("菜单表更新失败");
    }

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysMenuVO>>
    */
    @GetMapping
    public Result<List<SysMenuVO>> listByCondition(SysMenuAO sysMenuAO) {
        return sysMenuBusiness.listByCondition(sysMenuAO, this.getPageNum(), this.getPageSize());
    }
}