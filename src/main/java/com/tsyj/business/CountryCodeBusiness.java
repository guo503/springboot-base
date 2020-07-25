package com.tsyj.business;

import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.response.Result;
import com.tsyj.vo.CountryCodeVO;
import java.util.*;

/**
* 国际电话号码区号service类
* @author guos
* @date 2020/07/25 18:01
*/
public interface CountryCodeBusiness {
    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/07/25 18:01
    * @return CountryCodeVO
    */
    CountryCodeVO get(Integer id);

    
    /**
    * 新增国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/07/25 18:01
    * @return int
    */
    int save(CountryCode countryCode);

    
    /**
    * 更新国际电话号码区号
    * @param countryCode countryCode
    * @author guos
    * @date 2020/07/25 18:01
    * @return int
    */
    int update(CountryCode countryCode);

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeQuery countryCodeQuery
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/25 18:01
    * @return Result<List<CountryCodeVO>>
    */
    Result<List<CountryCodeVO>> listByCondition(CountryCodeQuery countryCodeQuery, int pageNum, int pageSize);

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeQuery countryCodeQuery
    * @author guos
    * @date 2020/07/25 18:01
    * @return int
    */
    int countByCondition(CountryCodeQuery countryCodeQuery);

    
    /**
    * 处理国际电话号码区号分批查询
    * @param countryCodeQuery countryCodeQuery
    * @author guos
    * @date 2020/07/25 18:01
    */
    void doBatch(CountryCodeQuery countryCodeQuery);
}