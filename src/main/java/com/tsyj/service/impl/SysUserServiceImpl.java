package com.tsyj.service.impl;

import com.tsyj.mapper.SysUserMapper;
import com.tsyj.model.SysUser;
import com.tsyj.service.SysUserService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 用户表service实现类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}