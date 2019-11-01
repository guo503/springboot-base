package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysRoleMenuBusiness;
import com.tsyj.model.SysRoleMenu;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.SysRoleMenuService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysRoleMenuVO;
import java.util.*;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 角色-菜单业务类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysRoleMenuBusinessImpl implements SysRoleMenuBusiness {
    
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    
    /**
    * 查询角色-菜单
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
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
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysRoleMenuVO sysRoleMenuVO) {
        if (sysRoleMenuVO == null) {
            throw new RuntimeException("角色-菜单信息不能为空!");
        }
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        BeanUtils.copyProperties(sysRoleMenuVO, sysRoleMenu);
        return sysRoleMenuService.save(sysRoleMenu);
    }

    
    /**
    * 更新角色-菜单
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysRoleMenuVO sysRoleMenuVO) {
        if (sysRoleMenuVO == null) {
            throw new RuntimeException("角色-菜单信息不能为空!");
        }
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        BeanUtils.copyProperties(sysRoleMenuVO, sysRoleMenu);
        return sysRoleMenuService.update(sysRoleMenu);
    }

    
    /**
    * 根据po查询角色-菜单列表
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysRoleMenuVO>>
    */
    @Override
    public Result<List<SysRoleMenuVO>> list(SysRoleMenuVO sysRoleMenuVO) {
        Result<List<SysRoleMenuVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        sysRoleMenuCond.limit(sysRoleMenuVO.getNum(), sysRoleMenuVO.getRow());
        int count = sysRoleMenuService.countByCondition(sysRoleMenuCond);
        if (count == 0){
            return result;
        }
        List<SysRoleMenuVO> sysRoleMenuVOList = ModelConvertUtils.convertList(SysRoleMenuVO.class, sysRoleMenuService.listByCondition(sysRoleMenuCond));
        return Result.success(sysRoleMenuVOList, count);
    }

    
    /**
    * 根据po查询角色-菜单总数
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int count(SysRoleMenuVO sysRoleMenuVO) {
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        return sysRoleMenuService.countByCondition(sysRoleMenuCond);
    }

    
    /**
    * 处理角色-菜单分批查询
    * @param sysRoleMenuVO sysRoleMenuVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    @Override
    public void doBatch(SysRoleMenuVO sysRoleMenuVO) {
        Condition<SysRoleMenu> sysRoleMenuCond = new Condition<>();
        int size = Page.getMaxRow() - 1 ;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<SysRoleMenu> list = sysRoleMenuService.batchList(gtId,sysRoleMenuCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}