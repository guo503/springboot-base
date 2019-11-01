package com.tsyj.controller;

import com.tsyj.business.SysMenuBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.SysMenuVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 菜单表api类
* @author guos
* @date 2019/10/31 18:20
*/
@CrossOrigin
@RestController
@RequestMapping("/sys-menu")
public class SysMenuController {
    
    @Autowired
    private SysMenuBusiness sysMenuBusiness;

    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<SysMenuVO>
    */
    @GetMapping("/{id}")
    public Result<SysMenuVO> get(@PathVariable("id") Integer id) {
        return Result.success(sysMenuBusiness.get(id));
    }

    
    /**
    * 新增菜单表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody SysMenuVO sysMenuVO) {
        return sysMenuBusiness.save(sysMenuVO) > 0 ? Result.success("菜单表添加成功"): Result.fail("菜单表添加失败");
    }

    
    /**
    * 更新菜单表
    * @param id id
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody SysMenuVO sysMenuVO) {
        sysMenuVO.setId(id);
        return sysMenuBusiness.update(sysMenuVO) > 0 ? Result.success("菜单表更新成功"): Result.fail("菜单表更新失败");
    }

    
    /**
    * 根据po查询菜单表列表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysMenuVO>>
    */
    @GetMapping
    public Result<List<SysMenuVO>> list(SysMenuVO sysMenuVO) {
        return sysMenuBusiness.list(sysMenuVO);
    }
}