package com.tsyj.service.impl;

import com.tsyj.mapper.CountryCodeMapper;
import com.tsyj.model.CountryCode;
import com.tsyj.service.CountryCodeService;
import mybatis.base.template.bs.service.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* 国际电话号码区号service实现类
* @author guos
* @date 2020/12/11 19:55
*/
@Service
public class CountryCodeServiceImpl extends ServiceImpl<CountryCodeMapper, CountryCode> implements CountryCodeService {
}