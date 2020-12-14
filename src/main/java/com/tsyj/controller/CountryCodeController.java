package com.tsyj.controller;

import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.query.CountryCodeQuery;
import com.tsyj.vo.CountryCodeVO;
import mybatis.base.template.bs.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* 国际电话号码区号api类
* @author guos
* @date 2020/12/12 16:28
*/
@RestController
@RequestMapping("/country-code")
public class CountryCodeController extends BaseController<CountryCodeBusiness, CountryCode, CountryCodeQuery, CountryCodeVO> {
}