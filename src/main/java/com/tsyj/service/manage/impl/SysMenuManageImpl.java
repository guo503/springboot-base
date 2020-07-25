package com.tsyj.service.manage.impl;

import com.tsyj.mapper.SysMenuMapper;
import com.tsyj.model.SysMenu;
import com.tsyj.service.manage.SysMenuManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 菜单表service实现类
* @author guos
* @date 2020/07/24 16:57
*/
@Service
public class SysMenuManageImpl extends ManageImpl<SysMenuMapper, SysMenu> implements SysMenuManage {
}