package com.tsyj.service.impl;

import com.tsyj.model.CountryCode;
import com.tsyj.service.CountryCodeService;
import com.tsyj.service.business.CountryCodeBusiness;
import java.util.*;
import mybatis.core.entity.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
* 国际电话号码区号service实现类
* @author guos
* @date 2020/06/20 15:12
*/
@Service
public class CountryCodeServiceImpl implements CountryCodeService {
    
    @Autowired
    private CountryCodeBusiness countryCodeBusiness;

    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/06/20 15:12
    * @return CountryCode
    */
    @Override
    public CountryCode get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return countryCodeBusiness.get(id);
    }

    
    /**
    * 根据countryCode查询国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/06/20 15:12
    * @return CountryCode
    */
    @Override
    public CountryCode getOne(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeBusiness.getOne(countryCode);
    }

    
    /**
    * 新增国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/06/20 15:12
    * @return int
    */
    @Override
    public int save(CountryCode countryCode) {
        return countryCodeBusiness.save(countryCode);
    }

    
    /**
    * 新增并返回国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/06/20 15:12
    * @return CountryCode
    */
    @Transactional
    @Override
    public CountryCode saveAndGet(CountryCode countryCode) {
        return countryCodeBusiness.saveAndGet(countryCode);
    }

    
    /**
    * 更新国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/06/20 15:12
    * @return int
    */
    @Override
    public int update(CountryCode countryCode) {
        return countryCodeBusiness.update(countryCode);
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2020/06/20 15:12
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> listByIds(List<Integer> ids) {
        Assert.notNull(ids,"ids不能为空");
        return countryCodeBusiness.listByIds(ids);
    }

    
    /**
    * 根据po查询国际电话号码区号列表
    * @param countryCode countryCode
    * @author guos
    * @date 2020/06/20 15:12
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> list(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeBusiness.list(countryCode);
    }

    
    /**
    * 根据po查询国际电话号码区号总数
    * @param countryCode countryCode
    * @author guos
    * @date 2020/06/20 15:12
    * @return int
    */
    @Override
    public int count(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeBusiness.count(countryCode);
    }

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/06/20 15:12
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> listByCondition(Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        return countryCodeBusiness.listByCondition(countryCodeCond);
    }

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/06/20 15:12
    * @return int
    */
    @Override
    public int countByCondition(Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        return countryCodeBusiness.countByCondition(countryCodeCond);
    }

    
    /**
    * 
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/06/20 15:12
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        return countryCodeBusiness.listId(countryCodeCond);
    }

    
    /**
    * 将符合查询条件的国际电话号码区号列表转map
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/06/20 15:12
    * @return Map<Integer, CountryCode>
    */
    @Override
    public Map<Integer, CountryCode> map(Condition<CountryCode> countryCodeCond) {
        return countryCodeBusiness.map(countryCodeCond);
    }

    
    /**
    * 将符合查询条件的国际电话号码区号列表转map
    * @param ids ids
    * @author guos
    * @date 2020/06/20 15:12
    * @return Map<Integer, CountryCode>
    */
    @Override
    public Map<Integer, CountryCode> mapByIds(List<Integer> ids) {
        return countryCodeBusiness.mapByIds(ids);
    }

    
    /**
    * 分批查询国际电话号码区号
    * @param gtId gtId
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/06/20 15:12
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> batchList(int gtId, Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        return countryCodeBusiness.batchList(gtId, countryCodeCond);
    }
}