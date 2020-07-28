package com.tsyj.business.impl;

import com.tsyj.business.UserBusiness;
import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.service.UserService;
import com.tsyj.vo.UserVO;
import mybatis.base.template.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 用户业务类
* @author guos
* @date 2020/07/28 16:16
*/
@Service
public class UserBusinessImpl extends BusinessImpl<UserService, User, UserQuery, UserVO> implements UserBusiness {
}