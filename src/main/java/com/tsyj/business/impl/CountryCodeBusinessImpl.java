package com.tsyj.business.impl;

import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.service.CountryCodeService;
import com.tsyj.vo.CountryCodeVO;
import mybatis.base.template.bs.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 国际电话号码区号业务类
* @author guos
* @date 2020/12/12 16:28
*/
@Service
public class CountryCodeBusinessImpl extends BusinessImpl<CountryCodeService, CountryCode, CountryCodeQuery, CountryCodeVO> implements CountryCodeBusiness {
}