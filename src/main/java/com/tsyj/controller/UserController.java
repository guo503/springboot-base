package com.tsyj.controller;

import com.tsyj.business.UserBusiness;
import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 用户api类
* @author guos
* @date 2020/07/25 10:42
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
    * @date 2020/07/25 10:42
    * @return Result<UserVO>
    */
    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable("id") Integer id) {
        return Result.success(userBusiness.get(id));
    }

    
    /**
    * 新增用户
    * @param user user
    * @author guos
    * @date 2020/07/25 10:42
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody User user) {
        return userBusiness.save(user) > 0 ? Result.success("用户添加成功"): Result.fail("用户添加失败");
    }

    
    /**
    * 更新用户
    * @param id id
    * @param user user
    * @author guos
    * @date 2020/07/25 10:42
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody User user) {
        user.setId(id);
        return userBusiness.update(user) > 0 ? Result.success("用户更新成功"): Result.fail("用户更新失败");
    }

    
    /**
    * 根据条件类查询用户列表
    * @param userQuery userQuery
    * @author guos
    * @date 2020/07/25 10:42
    * @return Result<List<UserVO>>
    */
    @GetMapping
    public Result<List<UserVO>> listByCondition(UserQuery userQuery) {
        return userBusiness.listByCondition(userQuery, this.getPageNum(), this.getPageSize());
    }
}