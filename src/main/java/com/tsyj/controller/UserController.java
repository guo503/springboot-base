package com.tsyj.controller;

import com.tsyj.apollo.config.OrderProperties;
import com.tsyj.business.UserBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
* 用户api类
* @author guos
* @date 2019/10/26 14:30
*/
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value(value = "${pay.timeout.seconds}")
    private Integer payTimeoutSeconds;

    @Value(value = "${pay.frequency.seconds}")
    private Integer createFrequencySeconds;
    
    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    private OrderProperties orderProperties;

    
    /**
    * 查询用户
    * @param id id
    * @author guos
    * @date 2019/10/26 14:30
    * @return Result<UserVO>
    */
    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable("id") Integer id) {
        logger.info("-------------通过@value获取------------------");
        logger.info("payTimeoutSeconds:" + payTimeoutSeconds);
        logger.info("createFrequencySeconds:" + createFrequencySeconds);
        logger.info("-------------通过@ConfigurationProperties获取------------------");
        logger.info("payTimeoutSeconds:" + orderProperties.getPayTimeoutSeconds());
        logger.info("createFrequencySeconds:" + orderProperties.getCreateFrequencySeconds());
        return Result.success(userBusiness.get(id));
    }

    
    /**
    * 新增用户
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody UserVO userVO) {
        return userBusiness.save(userVO) > 0 ? Result.success("用户添加成功"): Result.fail("用户添加失败");
    }

    
    /**
    * 更新用户
    * @param id id
    * @param userVO userVO
    * @author guos
    * @date 2019/10/26 14:30
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody UserVO userVO) {
        userVO.setId(id);
        return userBusiness.update(userVO) > 0 ? Result.success("用户更新成功"): Result.fail("用户更新失败");
    }
}