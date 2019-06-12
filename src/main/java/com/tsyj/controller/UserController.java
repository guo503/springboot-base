package com.tsyj.controller;

import com.tsyj.business.UserBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 用户api类
* @author guos
* @date 2019/06/12 11:10
*/
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserBusiness userBusiness;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/06/12 11:10
    * @return Result<UserVO>
    */
    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable("id") Integer id) {
        logger.info("-----get------,param: {}",id);
        return Result.success(userBusiness.get(id));
    }

    
    /**
    * 新增用户
    * @param userVO userVO
    * @author guos
    * @date 2019/06/12 11:10
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody UserVO userVO) {
        logger.info("-----save------,param: {}",userVO);
        return userBusiness.save(userVO) > 0 ? Result.success("用户添加成功"): Result.fail("用户添加失败");
    }

    
    /**
    * 更新用户
    * @param id id
    * @param userVO userVO
    * @author guos
    * @date 2019/06/12 11:10
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody UserVO userVO) {
        logger.info("-----update------,param: {}",userVO);
        userVO.setId(id);
        return userBusiness.update(userVO) > 0 ? Result.success("用户更新成功"): Result.fail("用户更新失败");
    }

    
    /**
    * 查询用户列表
    * @param userVO userVO
    * @author guos
    * @date 2019/06/12 11:10
    * @return Result<List<UserVO>>
    */
    @GetMapping
    public Result<List<UserVO>> list(UserVO userVO) {
        logger.info("-----list------,param: {}",userVO);
        return userBusiness.list(userVO);
    }
}