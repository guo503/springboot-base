package com.tsyj.query;

import lombok.Data;

import java.util.List;

/**
* 国际电话号码区号查询条件类
* @author guos
* @date 2020/07/28 18:25
*/
@Data
public class CountryCodeQuery {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String code;

    /**
     * 所在的洲
     */
    private String area;

    /**
     * 
     */
    private String flag;


    private List<Integer> ids;

    /**
     * 不等于id
     */
    private Integer neqId;

    /**
     * 大于等于id
     */
    private Integer gteId;

    /**
     * 小于等于id
     */
    private Integer lteId;

    /**
     * 名字模糊
     */
    private String lkName;


}