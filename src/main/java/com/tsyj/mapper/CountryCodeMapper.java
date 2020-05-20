package com.tsyj.mapper;

import com.tsyj.model.CountryCode;
import mybatis.base.mapper.Mapper;
import mybatis.base.mapper.SoftDeleteMapper;

/**
* 国际电话号码区号数据访问层
* @author guos
* @date 2020/05/20 13:49
*/
public interface CountryCodeMapper extends Mapper<CountryCode>, SoftDeleteMapper<CountryCode> {
}