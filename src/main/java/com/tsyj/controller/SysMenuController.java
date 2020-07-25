package com.tsyj.controller;

import com.tsyj.business.SysMenuBusiness;
import com.tsyj.model.SysMenu;
import com.tsyj.query.SysMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 菜单表api类
* @author guos
* @date 2020/07/24 16:57
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
    * @date 2020/07/24 16:57
    * @return Result<SysMenuVO>
    */
    @GetMapping("/{id}")
    public Result<SysMenuVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysMenuBusiness.get(id));
    }

    
    /**
    * 新增菜单表
    * @param sysMenu sysMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysMenu sysMenu) {
        return sysMenuBusiness.save(sysMenu) > 0 ? Result.success("菜单表添加成功"): Result.fail("菜单表添加失败");
    }

    
    /**
    * 更新菜单表
    * @param id id
    * @param sysMenu sysMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysMenu sysMenu) {
        sysMenu.setId(id);
        return sysMenuBusiness.update(sysMenu) > 0 ? Result.success("菜单表更新成功"): Result.fail("菜单表更新失败");
    }

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuQuery sysMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysMenuVO>>
    */
    @GetMapping
    public Result<List<SysMenuVO>> listByCondition(SysMenuQuery sysMenuQuery) {
        return sysMenuBusiness.listByCondition(sysMenuQuery, this.getPageNum(), this.getPageSize());
    }
}