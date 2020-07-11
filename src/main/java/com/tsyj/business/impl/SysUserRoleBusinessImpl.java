package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.ao.SysUserRoleAO;
import com.tsyj.business.SysUserRoleBusiness;
import com.tsyj.model.SysUserRole;
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
* @date 2020/07/11 17:24
*/
@Service
public class SysUserRoleBusinessImpl implements SysUserRoleBusiness {
    
    @Autowired
    private SysUserRoleService sysUserRoleService;

    
    /**
    * 查询用户-角色
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
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
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int save(SysUserRoleAO sysUserRoleAO) {
        if (sysUserRoleAO == null) {
            throw new RuntimeException("用户-角色信息不能为空!");
        }
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleAO, sysUserRole);
        return sysUserRoleService.save(sysUserRole);
    }

    
    /**
    * 更新用户-角色
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int update(SysUserRoleAO sysUserRoleAO) {
        if (sysUserRoleAO == null) {
            throw new RuntimeException("用户-角色信息不能为空!");
        }
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleAO, sysUserRole);
        return sysUserRoleService.update(sysUserRole);
    }

    
    /**
    * 根据条件类查询用户-角色列表
    * @param sysUserRoleAO sysUserRoleAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysUserRoleVO>>
    */
    @Override
    public Result<List<SysUserRoleVO>> listByCondition(SysUserRoleAO sysUserRoleAO, int pageNum, int pageSize) {
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
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int countByCondition(SysUserRoleAO sysUserRoleAO) {
        Condition<SysUserRole> sysUserRoleCond = new Condition<>();
        return sysUserRoleService.countByCondition(sysUserRoleCond);
    }

    
    /**
    * 处理用户-角色分批查询
    * @param sysUserRoleAO sysUserRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    @Override
    public void doBatch(SysUserRoleAO sysUserRoleAO) {
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