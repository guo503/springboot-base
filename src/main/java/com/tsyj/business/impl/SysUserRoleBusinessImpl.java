package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
import com.tsyj.query.SysUserRoleQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysUserRoleService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysUserRoleVO;
import java.util.*;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 用户-角色业务类
* @author guos
* @date 2020/07/24 16:57
*/
@Service
public class SysUserRoleBusinessImpl implements SysUserRoleBusiness {
    
    @Autowired
    private SysUserRoleService sysUserRoleService;

    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
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
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int save(SysUserRole sysUserRole) {
        if (sysUserRole == null) {
            throw new RuntimeException("用户-角色信息不能为空!");
        }
        return sysUserRoleService.save(sysUserRole);
    }

    
    /**
    * 更新用户-角色
    * @param sysUserRole sysUserRole
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int update(SysUserRole sysUserRole) {
        if (sysUserRole == null) {
            throw new RuntimeException("用户-角色信息不能为空!");
        }
        return sysUserRoleService.update(sysUserRole);
    }

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleQuery sysUserRoleQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysUserRoleVO>>
    */
    @Override
    public Result<List<SysUserRoleVO>> listByCondition(SysUserRoleQuery sysUserRoleQuery, int pageNum, int pageSize) {
        Result<List<SysUserRoleVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        sysUserRoleCond.limit(pageNum, pageSize);
        int count = sysUserRoleService.countByCondition(sysUserRoleCond);
        if (count == 0){
            return result;
        }
        List<SysUserRoleVO> sysUserRoleVOList = ModelConvertUtils.convertList(SysUserRoleVO.class, sysUserRoleService.listByCondition(sysUserRoleCond));
        return Result.success(sysUserRoleVOList, count);
    }

    
    /**
    * 根据条件类查询用户-角色总数
    * @param sysUserRoleQuery sysUserRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int countByCondition(SysUserRoleQuery sysUserRoleQuery) {
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        return sysUserRoleService.countByCondition(sysUserRoleCond);
    }

    
    /**
    * 处理用户-角色分批查询
    * @param sysUserRoleQuery sysUserRoleQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    @Override
    public void doBatch(SysUserRoleQuery sysUserRoleQuery) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        sysUserRoleCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<SysUserRole> list = sysUserRoleService.batchList(gtId,sysUserRoleCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}