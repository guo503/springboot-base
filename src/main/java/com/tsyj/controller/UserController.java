package com.tsyj.controller;

import com.tsyj.ao.UserAO;
import com.tsyj.business.UserBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 用户api类
* @author guos
* @date 2020/07/11 17:38
*/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    
    @Autowired
    private UserBusiness userBusiness;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2020/07/11 17:38
    * @return Result<UserVO>
    */
    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable("id") Integer id) {
        return Result.success(userBusiness.get(id));
    }

    
    /**
    * 新增用户
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody UserAO userAO) {
        return userBusiness.save(userAO) > 0 ? Result.success("用户添加成功"): Result.fail("用户添加失败");
    }

    
    /**
    * 更新用户
    * @param id id
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody UserAO userAO) {
        userAO.setId(id);
        return userBusiness.update(userAO) > 0 ? Result.success("用户更新成功"): Result.fail("用户更新失败");
    }

    
    /**
    * 根据条件类查询用户列表
    * @param userAO userAO
    * @author guos
    * @date 2020/07/11 17:38
    * @return Result<List<UserVO>>
    */
    @GetMapping
    public Result<List<UserVO>> listByCondition(UserAO userAO) {
        return userBusiness.listByCondition(userAO, this.getPageNum(), this.getPageSize());
    }
}