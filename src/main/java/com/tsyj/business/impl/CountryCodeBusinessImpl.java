package com.tsyj.business.impl;

import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.service.CountryCodeService;
import com.tsyj.vo.CountryCodeVO;
import mybatis.base.template.business.BusinessImpl;
import org.springframework.stereotype.Service;

/**
* 国际电话号码区号业务类
* @author guos
* @date 2020/07/30 09:39
*/
@Service
public class CountryCodeBusinessImpl extends BusinessImpl<CountryCodeService, CountryCode, CountryCodeQuery, CountryCodeVO> implements CountryCodeBusiness {
}