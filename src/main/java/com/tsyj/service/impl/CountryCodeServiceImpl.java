package com.tsyj.service.impl;

import com.tsyj.model.CountryCode;
import com.tsyj.service.CountryCodeService;
import com.tsyj.service.manage.CountryCodeManage;
import mybatis.base.template.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 国际电话号码区号service实现类
* @author guos
* @date 2020/07/25 18:01
*/
@Service
public class CountryCodeServiceImpl extends ServiceImpl<CountryCodeManage, CountryCode> implements CountryCodeService {
}