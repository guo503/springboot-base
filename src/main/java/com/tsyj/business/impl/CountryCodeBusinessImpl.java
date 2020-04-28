package com.tsyj.business.impl;

import com.google.common.collect.*;
import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.page.Page;
import com.tsyj.response.Result;
import com.tsyj.service.CountryCodeService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.CountryCodeVO;
import java.util.*;
import mybatis.core.entity.Condition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
* 国际电话号码区号业务类
* @author guos
* @date 2020/04/28 18:24
*/
@Service
public class CountryCodeBusinessImpl implements CountryCodeBusiness {
    
    @Autowired
    private CountryCodeService countryCodeService;

    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCodeVO
    */
    @Override
    public CountryCodeVO get(Integer id) {
        CountryCode countryCode = countryCodeService.get(id);
        CountryCodeVO countryCodeVO = new CountryCodeVO();
        if (countryCode == null) {
            return countryCodeVO;
        }
        BeanUtils.copyProperties(countryCode, countryCodeVO);
        return countryCodeVO;
    }

    
    /**
    * 新增国际电话号码区号
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int save(CountryCodeVO countryCodeVO) {
        if (countryCodeVO == null) {
            throw new RuntimeException("国际电话号码区号信息不能为空!");
        }
        CountryCode countryCode = new CountryCode();
        BeanUtils.copyProperties(countryCodeVO, countryCode);
        return countryCodeService.save(countryCode);
    }

    
    /**
    * 更新国际电话号码区号
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int update(CountryCodeVO countryCodeVO) {
        if (countryCodeVO == null) {
            throw new RuntimeException("国际电话号码区号信息不能为空!");
        }
        CountryCode countryCode = new CountryCode();
        BeanUtils.copyProperties(countryCodeVO, countryCode);
        return countryCodeService.update(countryCode);
    }

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return Result<List<CountryCodeVO>>
    */
    @Override
    public Result<List<CountryCodeVO>> listByCondition(CountryCodeVO countryCodeVO) {
        Result<List<CountryCodeVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<CountryCode> countryCodeCond = new Condition<>();
        countryCodeCond.limit(countryCodeVO.getNum(), countryCodeVO.getRow());
        int count = countryCodeService.countByCondition(countryCodeCond);
        if (count == 0){
            return result;
        }
        List<CountryCodeVO> countryCodeVOList = ModelConvertUtils.convertList(CountryCodeVO.class, countryCodeService.listByCondition(countryCodeCond));
        return Result.success(countryCodeVOList, count);
    }

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int countByCondition(CountryCodeVO countryCodeVO) {
        Condition<CountryCode> countryCodeCond = new Condition<>();
        return countryCodeService.countByCondition(countryCodeCond);
    }

    
    /**
    * 处理国际电话号码区号分批查询
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    */
    @Override
    public void doBatch(CountryCodeVO countryCodeVO) {
        Condition<CountryCode> countryCodeCond = new Condition<>();
        int size = Page.getMaxRow() - 1 ;
        int gtId = 0;
        while (size >= Page.getMaxRow() - 1) {
            List<CountryCode> list = countryCodeService.batchList(gtId,countryCodeCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}