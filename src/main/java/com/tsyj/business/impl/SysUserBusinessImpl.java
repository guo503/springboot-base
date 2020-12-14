package com.tsyj.business.impl;

import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.service.SysUserService;
import com.tsyj.vo.SysUserVO;
import mybatis.base.template.bs.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 用户表业务类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysUserBusinessImpl extends BusinessImpl<SysUserService, SysUser, SysUserQuery, SysUserVO> implements SysUserBusiness {
}