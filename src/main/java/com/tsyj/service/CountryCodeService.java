package com.tsyj.service;

import com.tsyj.model.CountryCode;
import java.util.*;
import java.util.Map;
import mybatis.core.entity.Condition;
import mybatis.core.entity.LimitCondition;

/**
* 国际电话号码区号service类
* @author guos
* @date 2020/04/28 18:24
*/
public interface CountryCodeService {
    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCode
    */
    CountryCode get(Integer id);

    
    /**
    * 根据countryCode查询国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCode
    */
    CountryCode getOne(CountryCode countryCode);

    
    /**
    * 新增国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int save(CountryCode countryCode);

    
    /**
    * 新增并返回国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCode
    */
    CountryCode saveAndGet(CountryCode countryCode);

    
    /**
    * 更新国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int update(CountryCode countryCode);

    
    /**
    * 
    * @param ids ids
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    List<CountryCode> listByIds(List<Integer> ids);

    
    /**
    * 根据po查询国际电话号码区号列表
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    List<CountryCode> list(CountryCode countryCode);

    
    /**
    * 根据po查询国际电话号码区号总数
    * @param countryCode countryCode
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int count(CountryCode countryCode);

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    List<CountryCode> listByCondition(Condition<CountryCode> countryCodeCond);

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int countByCondition(Condition<CountryCode> countryCodeCond);

    
    /**
    * 
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<Integer>
    */
    List<Integer> listId(Condition<CountryCode> countryCodeCond);

    
    /**
    * 将符合查询条件的国际电话号码区号列表转map
    * @param ids ids
    * @author guos
    * @date 2020/04/28 18:24
    * @return Map<Integer, CountryCode>
    */
    Map<Integer, CountryCode> mapByIds(List<Integer> ids);

    
    /**
    * 将符合查询条件的国际电话号码区号列表转map
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return Map<Integer, CountryCode>
    */
    Map<Integer, CountryCode> map(Condition<CountryCode> countryCodeCond);

    
    /**
    * 分批查询国际电话号码区号
    * @param gtId gtId
    * @param countryCodeCond countryCodeCond
    * @author guos
    * @date 2020/04/28 18:24
    * @return List<CountryCode>
    */
    List<CountryCode> batchList(int gtId, Condition<CountryCode> countryCodeCond);
}