package com.tsyj.business.impl;

import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.service.CountryCodeService;
import com.tsyj.vo.CountryCodeVO;
import mybatis.base.template.business.BusinessImpl;
import mybatis.core.entity.Condition;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 国际电话号码区号业务类
* @author guos
* @date 2020/07/28 18:25
*/
@Service
public class CountryCodeBusinessImpl extends BusinessImpl<CountryCodeService, CountryCode, CountryCodeQuery, CountryCodeVO> implements CountryCodeBusiness {


    @Override
    public List<CountryCodeVO> listByCondition(CountryCodeQuery countryCodeQuery, int pageNum, int pageSize) {
        Condition<CountryCode> condition = this.getCondition(countryCodeQuery);
        condition.setOrderBy(CountryCode.CODE).desc();
        return super.listByCondition(condition);
    }
}