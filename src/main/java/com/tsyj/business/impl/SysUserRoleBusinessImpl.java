package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.SysUserRoleService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 用户-角色业务类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysUserRoleBusinessImpl implements SysUserRoleBusiness {
    
    @Autowired
    private SysUserRoleService sysUserRoleService;

    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
    * @return SysUserRoleVO
    */
    @Override
    public SysUserRoleVO get(Integer id) {
        SysUserRole sysUserRole = sysUserRoleService.get(id);
        SysUserRoleVO sysUserRoleVO = new SysUserRoleVO();
        if (sysUserRole == null) {
            return sysUserRoleVO;
        }
        BeanUtils.copyProperties(sysUserRole, sysUserRoleVO);
        return sysUserRoleVO;
    }

    
    /**
    * 新增用户-角色
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysUserRoleVO sysUserRoleVO) {
        if (sysUserRoleVO == null) {
            throw new RuntimeException("用户-角色信息不能为空!");
        }
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleVO, sysUserRole);
        return sysUserRoleService.save(sysUserRole);
    }

    
    /**
    * 更新用户-角色
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysUserRoleVO sysUserRoleVO) {
        if (sysUserRoleVO == null) {
            throw new RuntimeException("用户-角色信息不能为空!");
        }
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleVO, sysUserRole);
        return sysUserRoleService.update(sysUserRole);
    }

    
    /**
    * 根据po查询用户-角色列表
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysUserRoleVO>>
    */
    @Override
    public Result<List<SysUserRoleVO>> list(SysUserRoleVO sysUserRoleVO) {
        Result<List<SysUserRoleVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        sysUserRoleCond.limit(sysUserRoleVO.getNum(), sysUserRoleVO.getRow());
        int count = sysUserRoleService.countByCondition(sysUserRoleCond);
        if (count == 0){
            return result;
        }
        List<SysUserRoleVO> sysUserRoleVOList = ModelConvertUtils.convertList(SysUserRoleVO.class, sysUserRoleService.listByCondition(sysUserRoleCond));
        return Result.success(sysUserRoleVOList, count);
    }

    
    /**
    * 根据po查询用户-角色总数
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int count(SysUserRoleVO sysUserRoleVO) {
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        return sysUserRoleService.countByCondition(sysUserRoleCond);
    }

    
    /**
    * 处理用户-角色分批查询
    * @param sysUserRoleVO sysUserRoleVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    @Override
    public void doBatch(SysUserRoleVO sysUserRoleVO) {
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        int size = Page.getMaxRow() - 1 ;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<SysUserRole> list = sysUserRoleService.batchList(gtId,sysUserRoleCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}