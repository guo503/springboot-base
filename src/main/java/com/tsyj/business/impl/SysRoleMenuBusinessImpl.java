package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.query.SysRoleMenuQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 角色-菜单业务类
* @author guos
* @date 2020/07/24 16:57
*/
@Service
public class SysRoleMenuBusinessImpl implements SysRoleMenuBusiness {
    
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysRoleMenuVO
    */
    @Override
    public SysRoleMenuVO get(Integer id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.get(id);
        SysRoleMenuVO sysRoleMenuVO = new SysRoleMenuVO();
        if (sysRoleMenu == null) {
            return sysRoleMenuVO;
        }
        BeanUtils.copyProperties(sysRoleMenu, sysRoleMenuVO);
        return sysRoleMenuVO;
    }

    
    /**
    * 新增角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int save(SysRoleMenu sysRoleMenu) {
        if (sysRoleMenu == null) {
            throw new RuntimeException("角色-菜单信息不能为空!");
        }
        return sysRoleMenuService.save(sysRoleMenu);
    }

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenu sysRoleMenu
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int update(SysRoleMenu sysRoleMenu) {
        if (sysRoleMenu == null) {
            throw new RuntimeException("角色-菜单信息不能为空!");
        }
        return sysRoleMenuService.update(sysRoleMenu);
    }

    
    /**
    * 根据条件类查询角色-菜单列表
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysRoleMenuVO>>
    */
    @Override
    public Result<List<SysRoleMenuVO>> listByCondition(SysRoleMenuQuery sysRoleMenuQuery, int pageNum, int pageSize) {
        Result<List<SysRoleMenuVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        sysRoleMenuCond.limit(pageNum, pageSize);
        int count = sysRoleMenuService.countByCondition(sysRoleMenuCond);
        if (count == 0){
            return result;
        }
        List<SysRoleMenuVO> sysRoleMenuVOList = ModelConvertUtils.convertList(SysRoleMenuVO.class, sysRoleMenuService.listByCondition(sysRoleMenuCond));
        return Result.success(sysRoleMenuVOList, count);
    }

    
    /**
    * 根据条件类查询角色-菜单总数
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int countByCondition(SysRoleMenuQuery sysRoleMenuQuery) {
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        return sysRoleMenuService.countByCondition(sysRoleMenuCond);
    }

    
    /**
    * 处理角色-菜单分批查询
    * @param sysRoleMenuQuery sysRoleMenuQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    @Override
    public void doBatch(SysRoleMenuQuery sysRoleMenuQuery) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        sysRoleMenuCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<SysRoleMenu> list = sysRoleMenuService.batchList(gtId,sysRoleMenuCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}