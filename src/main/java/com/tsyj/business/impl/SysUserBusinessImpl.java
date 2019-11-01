package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.SysUserBusiness;
import com.tsyj.model.SysUser;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.SysUserService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.SysUserVO;
import java.util.*;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 用户表业务类
* @author guos
* @date 2019/10/31 18:20
*/
@Service
public class SysUserBusinessImpl implements SysUserBusiness {
    
    @Autowired
    private SysUserService sysUserService;

    
    /**
    * 查询用户表
    * @param id id
    * @author guos
    * @date 2019/10/31 18:20
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
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int save(SysUserVO sysUserVO) {
        if (sysUserVO == null) {
            throw new RuntimeException("用户表信息不能为空!");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVO, sysUser);
        return sysUserService.save(sysUser);
    }

    
    /**
    * 更新用户表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int update(SysUserVO sysUserVO) {
        if (sysUserVO == null) {
            throw new RuntimeException("用户表信息不能为空!");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVO, sysUser);
        return sysUserService.update(sysUser);
    }

    
    /**
    * 根据po查询用户表列表
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return Result<List<SysUserVO>>
    */
    @Override
    public Result<List<SysUserVO>> list(SysUserVO sysUserVO) {
        Result<List<SysUserVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<SysUser> sysUserCond = new Condition<>();
        sysUserCond.limit(sysUserVO.getNum(), sysUserVO.getRow());
        int count = sysUserService.countByCondition(sysUserCond);
        if (count == 0){
            return result;
        }
        List<SysUserVO> sysUserVOList = ModelConvertUtils.convertList(SysUserVO.class, sysUserService.listByCondition(sysUserCond));
        return Result.success(sysUserVOList, count);
    }

    
    /**
    * 根据po查询用户表总数
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    * @return int
    */
    @Override
    public int count(SysUserVO sysUserVO) {
        Condition<SysUser> sysUserCond = new Condition<>();
        return sysUserService.countByCondition(sysUserCond);
    }

    
    /**
    * 处理用户表分批查询
    * @param sysUserVO sysUserVO
    * @author guos
    * @date 2019/10/31 18:20
    */
    @Override
    public void doBatch(SysUserVO sysUserVO) {
        Condition<SysUser> sysUserCond = new Condition<>();
        int size = Page.getMaxRow() - 1 ;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<SysUser> list = sysUserService.batchList(gtId,sysUserCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}