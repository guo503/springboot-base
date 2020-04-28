package com.tsyj.business;

import com.tsyj.response.Result;
import com.tsyj.vo.CountryCodeVO;
import java.util.*;

/**
* 国际电话号码区号service类
* @author guos
* @date 2020/04/28 18:24
*/
public interface CountryCodeBusiness {
    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/04/28 18:24
    * @return CountryCodeVO
    */
    CountryCodeVO get(Integer id);

    
    /**
    * 新增国际电话号码区号
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int save(CountryCodeVO countryCodeVO);

    
    /**
    * 更新国际电话号码区号
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int update(CountryCodeVO countryCodeVO);

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return Result<List<CountryCodeVO>>
    */
    Result<List<CountryCodeVO>> listByCondition(CountryCodeVO countryCodeVO);

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    * @return int
    */
    int countByCondition(CountryCodeVO countryCodeVO);

    
    /**
    * 处理国际电话号码区号分批查询
    * @param countryCodeVO countryCodeVO
    * @author guos
    * @date 2020/04/28 18:24
    */
    void doBatch(CountryCodeVO countryCodeVO);
}