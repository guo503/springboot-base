package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysUserService;
import com.tsyj.vo.SysUserVO;
import java.util.stream.Collectors;
import mybatis.base.template.business.BusinessImpl;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* 用户表业务类
* @author guos
* @date 2020/07/28 18:13
*/
@Service
public class SysUserBusinessImpl extends BusinessImpl<SysUserService, SysUser, SysUserQuery, SysUserVO> implements SysUserBusiness {
}