package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.ao.SysRoleAO;
import com.tsyj.business.SysRoleBusiness;
import com.tsyj.model.SysRole;
import com.tsyj.response.Result;
import com.tsyj.service.SysRoleService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysRoleVO;
import java.util.*;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 角色表业务类
* @author guos
* @date 2020/07/11 17:24
*/
@Service
public class SysRoleBusinessImpl implements SysRoleBusiness {
    
    @Autowired
    private SysRoleService sysRoleService;

    
    /**
    * 查询角色表
    * @param id id
    * @author guos
    * @date 2020/07/11 17:24
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
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int save(SysRoleAO sysRoleAO) {
        if (sysRoleAO == null) {
            throw new RuntimeException("角色表信息不能为空!");
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleAO, sysRole);
        return sysRoleService.save(sysRole);
    }

    
    /**
    * 更新角色表
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int update(SysRoleAO sysRoleAO) {
        if (sysRoleAO == null) {
            throw new RuntimeException("角色表信息不能为空!");
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleAO, sysRole);
        return sysRoleService.update(sysRole);
    }

    
    /**
    * 根据条件类查询角色表列表
    * @param sysRoleAO sysRoleAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/11 17:24
    * @return Result<List<SysRoleVO>>
    */
    @Override
    public Result<List<SysRoleVO>> listByCondition(SysRoleAO sysRoleAO, int pageNum, int pageSize) {
        Result<List<SysRoleVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysRole> sysRoleCond = new Condition<>();
        sysRoleCond.limit(pageNum, pageSize);
        int count = sysRoleService.countByCondition(sysRoleCond);
        if (count == 0){
            return result;
        }
        List<SysRoleVO> sysRoleVOList = ModelConvertUtils.convertList(SysRoleVO.class, sysRoleService.listByCondition(sysRoleCond));
        return Result.success(sysRoleVOList, count);
    }

    
    /**
    * 根据条件类查询角色表总数
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    * @return int
    */
    @Override
    public int countByCondition(SysRoleAO sysRoleAO) {
        Condition<SysRole> sysRoleCond = new Condition<>();
        return sysRoleService.countByCondition(sysRoleCond);
    }

    
    /**
    * 处理角色表分批查询
    * @param sysRoleAO sysRoleAO
    * @author guos
    * @date 2020/07/11 17:24
    */
    @Override
    public void doBatch(SysRoleAO sysRoleAO) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<SysRole> sysRoleCond = new Condition<>();
        sysRoleCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<SysRole> list = sysRoleService.batchList(gtId,sysRoleCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}