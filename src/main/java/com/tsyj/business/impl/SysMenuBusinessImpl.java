package com.tsyj.business.impl;

import com.google.common.collect.Lists;
import com.tsyj.business.SysMenuBusiness;
import com.tsyj.model.SysMenu;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.SysMenuService;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysMenuVO;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
* 菜单表业务类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysMenuBusinessImpl implements SysMenuBusiness {
    
    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    
    /**
    * 查询菜单表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
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
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysMenuVO sysMenuVO) {
        if (sysMenuVO == null) {
            throw new RuntimeException("菜单表信息不能为空!");
        }
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuVO, sysMenu);
        return sysMenuService.save(sysMenu);
    }

    
    /**
    * 更新菜单表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysMenuVO sysMenuVO) {
        if (sysMenuVO == null) {
            throw new RuntimeException("菜单表信息不能为空!");
        }
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuVO, sysMenu);
        return sysMenuService.update(sysMenu);
    }

    
    /**
    * 根据po查询菜单表列表
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysMenuVO>>
    */
    @Override
    public Result<List<SysMenuVO>> list(SysMenuVO sysMenuVO) {
        Result<List<SysMenuVO>> result = Result.success(Lists.newArrayList(), 0);
        List<Integer> sysMenuIds = null;
        if (sysMenuVO.getRoleId() != null) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(sysMenuVO.getRoleId());
            sysRoleMenu.setRow(Page.getMaxRow());
            List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.list(sysRoleMenu);
            if (CollectionUtils.isEmpty(sysRoleMenuList)) {
                return result;
            }
            sysMenuIds = sysRoleMenuList.stream().map(SysRoleMenu::getMenuId).distinct().collect(Collectors.toList());
        }
        Condition<SysMenu> sysMenuCond = new Condition<>();
        sysMenuCond.createCriteria().andIn(SysMenu.ID, sysMenuIds);
        sysMenuCond.limit(sysMenuVO.getNum(), sysMenuVO.getRow());
        int count = sysMenuService.countByCondition(sysMenuCond);
        if (count == 0) {
            return result;
        }
        List<SysMenuVO> sysMenuVOList = ModelConvertUtils.convertList(SysMenuVO.class, sysMenuService.listByCondition(sysMenuCond));
        return Result.success(sysMenuVOList, count);
    }

    
    /**
    * 根据po查询菜单表总数
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int count(SysMenuVO sysMenuVO) {
        Condition<SysMenu> sysMenuCond = new Condition<>();
        return sysMenuService.countByCondition(sysMenuCond);
    }

    
    /**
    * 处理菜单表分批查询
    * @param sysMenuVO sysMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    @Override
    public void doBatch(SysMenuVO sysMenuVO) {
        Condition<SysMenu> sysMenuCond = new Condition<>();
        int size = Page.getMaxRow() - 1 ;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<SysMenu> list = sysMenuService.batchList(gtId,sysMenuCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}