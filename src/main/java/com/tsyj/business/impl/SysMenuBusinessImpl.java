package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.ao.SysMenuAO;
import com.tsyj.business.SysMenuBusiness;
import com.tsyj.model.SysMenu;
import com.tsyj.response.Result;
import com.tsyj.service.SysMenuService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysMenuVO;
import java.util.*;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 菜单表业务类
* @author guos
* @date 2020/07/11 17:24
*/
@Service
public class SysMenuBusinessImpl implements SysMenuBusiness {
    
    @Autowired
    private SysMenuService sysMenuService;

    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
    * @return SysMenuVO
    */
    @Override
    public SysMenuVO get(Integer id) {
        SysMenu sysMenu = sysMenuService.get(id);
        SysMenuVO sysMenuVO = new SysMenuVO();
        if (sysMenu == null) {
            return sysMenuVO;
        }
        BeanUtils.copyProperties(sysMenu, sysMenuVO);
        return sysMenuVO;
    }

    
    /**
    * 新增菜单表
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int save(SysMenuAO sysMenuAO) {
        if (sysMenuAO == null) {
            throw new RuntimeException("菜单表信息不能为空!");
        }
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuAO, sysMenu);
        return sysMenuService.save(sysMenu);
    }

    
    /**
    * 更新菜单表
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int update(SysMenuAO sysMenuAO) {
        if (sysMenuAO == null) {
            throw new RuntimeException("菜单表信息不能为空!");
        }
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuAO, sysMenu);
        return sysMenuService.update(sysMenu);
    }

    
    /**
    * 根据条件类查询菜单表列表
    * @param sysMenuAO sysMenuAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysMenuVO>>
    */
    @Override
    public Result<List<SysMenuVO>> listByCondition(SysMenuAO sysMenuAO, int pageNum, int pageSize) {
        Result<List<SysMenuVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysMenu> sysMenuCond = new Condition<>();
        sysMenuCond.limit(pageNum, pageSize);
        int count = sysMenuService.countByCondition(sysMenuCond);
        if (count == 0){
            return result;
        }
        List<SysMenuVO> sysMenuVOList = ModelConvertUtils.convertList(SysMenuVO.class, sysMenuService.listByCondition(sysMenuCond));
        return Result.success(sysMenuVOList, count);
    }

    
    /**
    * 根据条件类查询菜单表总数
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int countByCondition(SysMenuAO sysMenuAO) {
        Condition<SysMenu> sysMenuCond = new Condition<>();
        return sysMenuService.countByCondition(sysMenuCond);
    }

    
    /**
    * 处理菜单表分批查询
    * @param sysMenuAO sysMenuAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    @Override
    public void doBatch(SysMenuAO sysMenuAO) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<SysMenu> sysMenuCond = new Condition<>();
        sysMenuCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<SysMenu> list = sysMenuService.batchList(gtId,sysMenuCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}