package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.SysRoleService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysRoleVO;
import java.util.*;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 角色表业务类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysRoleBusinessImpl implements SysRoleBusiness {
    
    @Autowired
    private SysRoleService sysRoleService;

    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysRoleVO
    */
    @Override
    public SysRoleVO get(Integer id) {
        SysRole sysRole = sysRoleService.get(id);
        SysRoleVO sysRoleVO = new SysRoleVO();
        if (sysRole == null) {
            return sysRoleVO;
        }
        BeanUtils.copyProperties(sysRole, sysRoleVO);
        return sysRoleVO;
    }

    
    /**
    * 新增角色表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysRoleVO sysRoleVO) {
        if (sysRoleVO == null) {
            throw new RuntimeException("角色表信息不能为空!");
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleVO, sysRole);
        return sysRoleService.save(sysRole);
    }

    
    /**
    * 更新角色表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysRoleVO sysRoleVO) {
        if (sysRoleVO == null) {
            throw new RuntimeException("角色表信息不能为空!");
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleVO, sysRole);
        return sysRoleService.update(sysRole);
    }

    
    /**
    * 根据po查询角色表列表
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysRoleVO>>
    */
    @Override
    public Result<List<SysRoleVO>> list(SysRoleVO sysRoleVO) {
        Result<List<SysRoleVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysRole> sysRoleCond = new Condition<>();
        sysRoleCond.limit(sysRoleVO.getNum(), sysRoleVO.getRow());
        int count = sysRoleService.countByCondition(sysRoleCond);
        if (count == 0){
            return result;
        }
        List<SysRoleVO> sysRoleVOList = ModelConvertUtils.convertList(SysRoleVO.class, sysRoleService.listByCondition(sysRoleCond));
        return Result.success(sysRoleVOList, count);
    }

    
    /**
    * 根据po查询角色表总数
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int count(SysRoleVO sysRoleVO) {
        Condition<SysRole> sysRoleCond = new Condition<>();
        return sysRoleService.countByCondition(sysRoleCond);
    }

    
    /**
    * 处理角色表分批查询
    * @param sysRoleVO sysRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    @Override
    public void doBatch(SysRoleVO sysRoleVO) {
        Condition<SysRole> sysRoleCond = new Condition<>();
        int size = Page.getMaxRow() - 1 ;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<SysRole> list = sysRoleService.batchList(gtId,sysRoleCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}