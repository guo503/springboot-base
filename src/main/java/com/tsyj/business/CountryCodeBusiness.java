package com.tsyj.business;

import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.vo.CountryCodeVO;
import mybatis.base.template.business.IBusiness;

/**
* 国际电话号码区号service类
* @author guos
* @date 2020/08/15 11:19
*/
public interface CountryCodeBusiness extends IBusiness<CountryCode, CountryCodeQuery, CountryCodeVO> {
}