package com.tsyj.business;

import com.tsyj.ao.CountryCodeAO;
import com.tsyj.response.Result;
import com.tsyj.vo.CountryCodeVO;
import java.util.*;

/**
* 国际电话号码区号service类
* @author guos
* @date 2020/07/01 11:32
*/
public interface CountryCodeBusiness {
    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/07/01 11:32
    * @return CountryCodeVO
    */
    CountryCodeVO get(Integer id);

    
    /**
    * 新增国际电话号码区号
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/01 11:32
    * @return int
    */
    int save(CountryCodeAO countryCodeAO);

    
    /**
    * 更新国际电话号码区号
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/01 11:32
    * @return int
    */
    int update(CountryCodeAO countryCodeAO);

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/01 11:32
    * @return Result<List<CountryCodeVO>>
    */
    Result<List<CountryCodeVO>> listByCondition(CountryCodeAO countryCodeAO);

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/01 11:32
    * @return int
    */
    int countByCondition(CountryCodeAO countryCodeAO);
}