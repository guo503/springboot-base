package com.tsyj.model;

import lombok.Data;
import mybatis.core.annotation.Id;
import mybatis.core.annotation.Table;

import java.io.Serializable;

/**
* 国际电话号码区号实体类
* @author guos
* @date 2020/07/11 16:56
*/
@Table(name = "country_code")
@Data
public class CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 163385487812572L;

    /**
     * 
     */
    @Id()
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

    
    
    
    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String CODE = "code";

    public static final String AREA = "area";

    public static final String FLAG = "flag";
}