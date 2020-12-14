package com.tsyj.business;

import com.tsyj.model.User;
import com.tsyj.query.UserQuery;
import com.tsyj.vo.UserVO;
import mybatis.base.template.bs.business.IBusiness;

/**
* 用户service类
* @author guos
* @date 2020/12/12 16:28
*/
public interface UserBusiness extends IBusiness<User, UserQuery, UserVO> {
}