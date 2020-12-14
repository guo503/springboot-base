package com.tsyj.service.impl;

import com.tsyj.mapper.SysMenuMapper;
import com.tsyj.model.SysMenu;
import com.tsyj.service.SysMenuService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 菜单表service实现类
* @author guos
* @date 2020/12/14 17:43
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
}