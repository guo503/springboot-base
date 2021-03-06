package com.tsyj.query;

import lombok.Data;

/**
* 国际电话号码区号查询条件类
* @author guos
* @date 2020/12/12 16:28
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
}