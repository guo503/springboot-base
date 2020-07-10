package com.tsyj.business.impl;

import com.google.common.collect.Lists;
import com.tsyj.ao.CountryCodeAO;
import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.model.CountryCode;
import com.tsyj.response.Result;
import com.tsyj.service.CountryCodeService;
import com.tsyj.utils.ModelConvertUtils;
import com.tsyj.vo.CountryCodeVO;
import mybatis.core.entity.Condition;
import mybatis.core.page.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
* 国际电话号码区号业务类
* @author guos
* @date 2020/07/10 10:23
*/
@Service
public class CountryCodeBusinessImpl implements CountryCodeBusiness {
    
    @Autowired
    private CountryCodeService countryCodeService;

    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/07/10 10:23
    * @return CountryCodeVO
    */
    @Override
    public CountryCodeVO get(Integer id) {
        CountryCode countryCode = countryCodeService.get(id);
        CountryCodeVO countryCodeVO = new CountryCodeVO();
        if (countryCode == null) {
            return countryCodeVO;
        }
        BeanUtils.copyProperties(countryCode, countryCodeVO);
        return countryCodeVO;
    }

    
    /**
    * 新增国际电话号码区号
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/10 10:23
    * @return int
    */
    @Override
    public int save(CountryCodeAO countryCodeAO) {
        if (countryCodeAO == null) {
            throw new RuntimeException("国际电话号码区号信息不能为空!");
        }
        CountryCode countryCode = new CountryCode();
        BeanUtils.copyProperties(countryCodeAO, countryCode);
        return countryCodeService.save(countryCode);
    }

    
    /**
    * 更新国际电话号码区号
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/10 10:23
    * @return int
    */
    @Override
    public int update(CountryCodeAO countryCodeAO) {
        if (countryCodeAO == null) {
            throw new RuntimeException("国际电话号码区号信息不能为空!");
        }
        CountryCode countryCode = new CountryCode();
        BeanUtils.copyProperties(countryCodeAO, countryCode);
        return countryCodeService.update(countryCode);
    }

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeAO countryCodeAO
    * @param pageNum pageNum
    * @param pageSize pageSize
    * @author guos
    * @date 2020/07/10 10:23
    * @return Result<List<CountryCodeVO>>
    */
    @Override
    public Result<List<CountryCodeVO>> listByCondition(CountryCodeAO countryCodeAO, int pageNum, int pageSize) {
        Result<List<CountryCodeVO>> result = Result.success(Lists.newArrayList(), 0);
        Condition<CountryCode> countryCodeCond = new Condition<>();
        countryCodeCond.limit(pageNum, pageSize);
        int count = countryCodeService.countByCondition(countryCodeCond);
        if (count == 0){
            return result;
        }
        List<CountryCodeVO> countryCodeVOList = ModelConvertUtils.convertList(CountryCodeVO.class, countryCodeService.listByCondition(countryCodeCond));
        return Result.success(countryCodeVOList, count);
    }

    
    /**
    * 根据条件类查询国际电话号码区号总数
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/10 10:23
    * @return int
    */
    @Override
    public int countByCondition(CountryCodeAO countryCodeAO) {
        Condition<CountryCode> countryCodeCond = new Condition<>();
        return countryCodeService.countByCondition(countryCodeCond);
    }

    
    /**
    * 处理国际电话号码区号分批查询
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/10 10:23
    */
    @Override
    public void doBatch(CountryCodeAO countryCodeAO) {
        int maxSize = Page.MAX_SIZE - 1 ;
        Condition<CountryCode> countryCodeCond = new Condition<>();
        countryCodeCond.limit(maxSize) ;
        int size = maxSize ;
        int gtId = 0;
        while (size >= maxSize) {
            List<CountryCode> list = countryCodeService.batchList(gtId,countryCodeCond);
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            size = list.size();
            gtId = list.get(size - 1).getId();
        }
    }
}