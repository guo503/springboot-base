package com.tsyj.mapper;

import com.tsyj.model.SysMenu;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 菜单表数据访问层
* @author guos
* @date 2020/12/14 17:43
*/
public interface SysMenuMapper extends Mapper<SysMenu>, SoftDeleteMapper<SysMenu> {
}