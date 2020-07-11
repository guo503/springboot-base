package com.tsyj.service.manage.impl;

import com.tsyj.mapper.CountryCodeMapper;
import com.tsyj.model.CountryCode;
import com.tsyj.service.manage.CountryCodeManage;
import mybatis.base.template.manage.ManageImpl;
import org.springframework.stereotype.Service;

/**
* 国际电话号码区号service实现类
* @author guos
* @date 2020/07/11 17:37
*/
@Service
public class CountryCodeManageImpl extends ManageImpl<CountryCodeMapper, CountryCode> implements CountryCodeManage {
}