package com.tsyj.mapper;

import com.tsyj.model.SysMenu;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 菜单表数据访问层
* @author guos
* @date 2019/10/31 18:20
*/
public interface SysMenuMapper extends Mapper<SysMenu>, SoftDeleteMapper<SysMenu> {
}