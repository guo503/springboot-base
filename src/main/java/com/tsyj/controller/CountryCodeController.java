package com.tsyj.controller;

import com.tsyj.ao.CountryCodeAO;
import com.tsyj.business.CountryCodeBusiness;
import com.tsyj.response.Result;
import com.tsyj.vo.CountryCodeVO;
import java.util.*;
import mybatis.spring.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 国际电话号码区号api类
* @author guos
* @date 2020/07/11 16:56
*/
@RestController
@RequestMapping("/country-code")
public class CountryCodeController extends BaseController {
    
    @Autowired
    private CountryCodeBusiness countryCodeBusiness;

    
    /**
    * 查询国际电话号码区号
    * @param id id
    * @author guos
    * @date 2020/07/11 16:56
    * @return Result<CountryCodeVO>
    */
    @GetMapping("/{id}")
    public Result<CountryCodeVO> get(@PathVariable("id") Integer id) {
        return Result.success(countryCodeBusiness.get(id));
    }

    
    /**
    * 新增国际电话号码区号
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/11 16:56
    * @return Result<Object>
    */
    @PostMapping
    public Result<Object> save(@RequestBody CountryCodeAO countryCodeAO) {
        return countryCodeBusiness.save(countryCodeAO) > 0 ? Result.success("国际电话号码区号添加成功"): Result.fail("国际电话号码区号添加失败");
    }

    
    /**
    * 更新国际电话号码区号
    * @param id id
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/11 16:56
    * @return Result<Object>
    */
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody CountryCodeAO countryCodeAO) {
        countryCodeAO.setId(id);
        return countryCodeBusiness.update(countryCodeAO) > 0 ? Result.success("国际电话号码区号更新成功"): Result.fail("国际电话号码区号更新失败");
    }

    
    /**
    * 根据条件类查询国际电话号码区号列表
    * @param countryCodeAO countryCodeAO
    * @author guos
    * @date 2020/07/11 16:56
    * @return Result<List<CountryCodeVO>>
    */
    @GetMapping
    public Result<List<CountryCodeVO>> listByCondition(CountryCodeAO countryCodeAO) {
        return countryCodeBusiness.listByCondition(countryCodeAO, this.getPageNum(), this.getPageSize());
    }
}