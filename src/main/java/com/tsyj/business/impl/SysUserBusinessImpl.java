package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.query.SysUserQuery;
import com.tsyj.response.Result;
import com.tsyj.service.SysUserService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysUserVO;
import java.util.*;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 用户表业务类
* @author guos
* @date 2020/07/24 16:57
*/
@Service
public class SysUserBusinessImpl implements SysUserBusiness {
    
    @Autowired
    private SysUserService sysUserService;

    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2020/07/24 16:57
    * @return SysUserVO
    */
    @Override
    public SysUserVO get(Integer id) {
        SysUser sysUser = sysUserService.get(id);
        SysUserVO sysUserVO = new SysUserVO();
        if (sysUser == null) {
            return sysUserVO;
        }
        BeanUtils.copyProperties(sysUser, sysUserVO);
        return sysUserVO;
    }

    
    /**
    * 新增用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int save(SysUser sysUser) {
        if (sysUser == null) {
            throw new RuntimeException("用户表信息不能为空!");
        }
        return sysUserService.save(sysUser);
    }

    
    /**
    * 更新用户表
    * @param sysUser sysUser
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int update(SysUser sysUser) {
        if (sysUser == null) {
            throw new RuntimeException("用户表信息不能为空!");
        }
        return sysUserService.update(sysUser);
    }

    
    /**
    * 根据条件类查询用户表列表
    * @param sysUserQuery sysUserQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/24 16:57
    * @return Result<List<SysUserVO>>
    */
    @Override
    public Result<List<SysUserVO>> listByCondition(SysUserQuery sysUserQuery, int pageNum, int pageSize) {
        Result<List<SysUserVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysUser> sysUserCond = new Condition<>();
        sysUserCond.limit(pageNum, pageSize);
        int count = sysUserService.countByCondition(sysUserCond);
        if (count == 0){
            return result;
        }
        List<SysUserVO> sysUserVOList = ModelConvertUtils.convertList(SysUserVO.class, sysUserService.listByCondition(sysUserCond));
        return Result.success(sysUserVOList, count);
    }

    
    /**
    * 根据条件类查询用户表总数
    * @param sysUserQuery sysUserQuery
    * @author guos
    * @date 2020/07/24 16:57
    * @return int
    */
    @Override
    public int countByCondition(SysUserQuery sysUserQuery) {
        Condition<SysUser> sysUserCond = new Condition<>();
        return sysUserService.countByCondition(sysUserCond);
    }

    
    /**
    * 处理用户表分批查询
    * @param sysUserQuery sysUserQuery
    * @author guos
    * @date 2020/07/24 16:57
    */
    @Override
    public void doBatch(SysUserQuery sysUserQuery) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<SysUser> sysUserCond = new Condition<>();
        sysUserCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<SysUser> list = sysUserService.batchList(gtId,sysUserCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}