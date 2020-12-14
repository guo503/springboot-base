package com.tsyj.business;

import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.vo.SysUserVO;
import mybatis.base.template.bs.business.IBusiness;

/**
* 用户表service类
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysUserBusiness extends IBusiness<SysUser, SysUserQuery, SysUserVO> {
}