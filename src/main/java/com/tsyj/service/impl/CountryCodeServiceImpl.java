package com.tsyj.service.impl;

import com.google.common.collect.*;
import com.tsyj.consts.UserConst;
import com.tsyj.mapper.CountryCodeMapper;
import com.tsyj.model.CountryCode;
import com.tsyj.page.Page;
import com.tsyj.service.CountryCodeService;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.*;
import org.springframework.util.Assert;

/**
* 国际电话号码区号service实现类
* @author guos
* @date 2020/04/28 18:24
*/
@Service
public class CountryCodeServiceImpl implements CountryCodeService {
    
    @Autowired
    private CountryCodeMapper countryCodeMapper;

    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCode
    */
    @Override
    public CountryCode get(Integer id) {
        Assert.notNull(id,"id不能为空");
        return countryCodeMapper.getx(id);
    }

    
    /**
    * 根据countryCode查询国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCode
    */
    @Override
    public CountryCode getOne(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeMapper.getOnex(countryCode);
    }

    
    /**
    * 新增国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int save(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeMapper.savex(countryCode);
    }

    
    /**
    * 新增并返回国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCode
    */
    @Transactional
    @Override
    public CountryCode saveAndGet(CountryCode countryCode) {
        this.save(countryCode);
        return this.get(countryCode.getId());
    }

    
    /**
    * 更新国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int update(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeMapper.updatex(countryCode);
    }

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> listByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Condition<CountryCode> countryCodeCond = new Condition<>();
        countryCodeCond.createCriteria().andIn(CountryCode.ID, ids);
        countryCodeCond.limit(Page.getMaxRow());
        return this.listByCondition(countryCodeCond);
    }

    
    /**
    * 根据po查询国际电话号码区号列表
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> list(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeMapper.listLimitx(countryCode, new LimitCondition(countryCode.getStart(), countryCode.getRow()));
    }

    
    /**
    * 根据po查询国际电话号码区号总数
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int count(CountryCode countryCode) {
        Assert.notNull(countryCode,"countryCode不能为空");
        return countryCodeMapper.countx(countryCode);
    }

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> listByCondition(Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        return countryCodeMapper.listByConditionx(countryCodeCond);
    }

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    @Override
    public int countByCondition(Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        return countryCodeMapper.countByConditionx(countryCodeCond);
    }

    
    /**
    * 
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<Integer>
    */
    @Override
    public List<Integer> listId(Condition<CountryCode> countryCodeCond) {
        List<CountryCode> list = this.listByCondition(countryCodeCond);
        return list.stream().map(CountryCode::getId).distinct().collect(Collectors.toList());
    }

    
    /**
    * 将符合查询条件的国际电话号码区号列表转map
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return Map<Integer, CountryCode>
    */
    @Override
    public Map<Integer, CountryCode> map(Condition<CountryCode> countryCodeCond) {
        List<CountryCode> countryCodeList = this.listByCondition(countryCodeCond);
        return countryCodeList.stream().collect(Collectors.toMap(CountryCode::getId,countryCode -> countryCode, (k1, k2) -> k2));
    }

    
    /**
    * 将符合查询条件的国际电话号码区号列表转map
    * @param ids ids
    * @author guos
    * @date 2020/04/28 18:24
    * @return Map<Integer, CountryCode>
    */
    @Override
    public Map<Integer, CountryCode> mapByIds(List<Integer> ids) {
        List<CountryCode> countryCodeList = this.listByIds(ids);
        return countryCodeList.stream().collect(Collectors.toMap(CountryCode::getId,countryCode -> countryCode, (k1, k2) -> k2));
    }

    
    /**
    * 分批查询国际电话号码区号
    * @param gtId gtId
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    @Override
    public List<CountryCode> batchList(int gtId, Condition<CountryCode> countryCodeCond) {
        Assert.notNull(countryCodeCond,"countryCodeCond不能为空");
        countryCodeCond.limit(1,Page.getMaxRow() - 1);
        countryCodeCond.setOrderBy(CountryCode.ID);
        countryCodeCond.andCriteria().andGreaterThan(CountryCode.ID, gtId);
        return this.listByCondition(countryCodeCond);
    }
}