package com.tsyj.business.impl;

import com.google.common.collect.Lists;
import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.response.Result;
import com.tsyj.service.CountryCodeService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.CountryCodeVO;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
* 国际电话号码区号业务类
* @author guos
* @date 2020/07/25 18:01
*/
@Service
public class CountryCodeBusinessImpl implements CountryCodeBusiness {
    
    @Autowired
    private CountryCodeService countryCodeService;

    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/07/25 18:01
    * @return CountryCodeVO
    */
    @Override
    public CountryCodeVO get(Integer id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("id不能为空!");
        }
        CountryCode countryCode = countryCodeService.get(id);
        CountryCodeVO countryCodeVO = new CountryCodeVO();
        if (Objects.isNull(countryCode)) {
            return countryCodeVO;
        }
        BeanUtils.copyProperties(countryCode, countryCodeVO);
        return countryCodeVO;
    }

    
    /**
    * 新增国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/07/25 18:01
    * @return int
    */
    @Override
    public int save(CountryCode countryCode) {
        if (Objects.isNull(countryCode)) {
            throw new RuntimeException("国际电话号码区号信息不能为空!");
        }
        return countryCodeService.save(countryCode);
    }

    
    /**
    * 更新国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/07/25 18:01
    * @return int
    */
    @Override
    public int update(CountryCode countryCode) {
        if (Objects.isNull(countryCode)) {
            throw new RuntimeException("国际电话号码区号信息不能为空!");
        }
        return countryCodeService.update(countryCode);
    }

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeQuery countryCodeQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/25 18:01
    * @return Result<List<CountryCodeVO>>
    */
    @Override
    public Result<List<CountryCodeVO>> listByCondition(CountryCodeQuery countryCodeQuery, int pageNum, int pageSize) {
        Result<List<CountryCodeVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<CountryCode> countryCodeCond = new Condition<>();
        countryCodeCond.limit(pageNum, pageSize);
        Condition<CountryCode>.Criteria criteria = countryCodeCond.createCriteria();
        if (Objects.nonNull(countryCodeQuery.getId())) {
            criteria.andEqual(CountryCode.ID, countryCodeQuery.getId());
        }
        int count = countryCodeService.countByCondition(countryCodeCond);
        if (count == 0){
            return result;
        }
        List<CountryCodeVO> countryCodeVOList = ModelConvertUtils.convertList(CountryCodeVO.class, countryCodeService.listByCondition(countryCodeCond));
        return Result.success(countryCodeVOList, count);
    }

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeQuery countryCodeQuery
    * @author guos
    * @date 2020/07/25 18:01
    * @return int
    */
    @Override
    public int countByCondition(CountryCodeQuery countryCodeQuery) {
        Condition<CountryCode> countryCodeCond = new Condition<>();
        return countryCodeService.countByCondition(countryCodeCond);
    }

    
    /**
    * 处理国际电话号码区号分批查询
    * @param countryCodeQuery countryCodeQuery
    * @author guos
    * @date 2020/07/25 18:01
    */
    @Override
    public void doBatch(CountryCodeQuery countryCodeQuery) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<CountryCode> countryCodeCond = new Condition<>();
        countryCodeCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<CountryCode> list = countryCodeService.batchList(gtId,countryCodeCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}