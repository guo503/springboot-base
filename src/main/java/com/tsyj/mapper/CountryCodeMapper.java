package com.tsyj.mapper;

import com.tsyj.model.CountryCode;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 国际电话号码区号数据访问层
* @author guos
* @date 2020/04/28 18:24
*/
public interface CountryCodeMapper extends Mapper<CountryCode>, SoftDeleteMapper<CountryCode> {
}