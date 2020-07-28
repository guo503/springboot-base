package com.tsyj.controller;

import com.tsyj.business.UserBusiness;
import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.vo.UserVO;
import mybatis.base.template.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 用户api类
* @author guos
* @date 2020/07/28 16:16
*/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserBusiness, User, UserQuery, UserVO> {
}