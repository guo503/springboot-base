package com.tsyj.business;

import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.SysUserVO;
import java.util.*;
import mybatis.base.template.business.IBusiness;

/**
* 用户表service类
* @author guos
* @date 2020/07/28 18:13
*/
public interface SysUserBusiness extends IBusiness<SysUser, SysUserQuery, SysUserVO> {
}