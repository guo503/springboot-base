package com.tsyj.business;

import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.vo.UserVO;
import mybatis.base.template.business.IBusiness;

/**
* 用户service类
* @author guos
* @date 2020/07/28 16:16
*/
public interface UserBusiness extends IBusiness<User, UserQuery, UserVO> {
}