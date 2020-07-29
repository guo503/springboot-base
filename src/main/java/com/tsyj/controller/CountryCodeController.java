package com.tsyj.controller;

import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.vo.CountryCodeVO;
import mybatis.base.template.controller.BaseController;
import mybatis.base.template.controller.response.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 国际电话号码区号api类
* @author guos
* @date 2020/07/28 18:25
*/
@RestController
@RequestMapping("/country-code")
public class CountryCodeController extends BaseController<CountryCodeBusiness, CountryCode, CountryCodeQuery, CountryCodeVO> {


    @Override
    public Result<List<CountryCodeVO>> listByCondition(CountryCodeQuery countryCodeQuery) {
        return Result.success(baseBusiness.listByCondition(countryCodeQuery,this.getPageNum(),this.getPageSize()));
    }
}