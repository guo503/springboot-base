package com.tsyj.service.impl;

import com.tsyj.model.SysMenu;
import com.tsyj.service.SysMenuService;
import com.tsyj.service.manage.SysMenuManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 菜单表service实现类
* @author guos
* @date 2020/07/24 16:57
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuManage, SysMenu> implements SysMenuService {
}