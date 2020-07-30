package com.tsyj.query;

import lombok.Data;

import java.util.List;

/**
* 国际电话号码区号查询条件类
* @author guos
* @date 2020/07/30 09:39
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



    private Integer neqId;

    private List<Integer> ids;

    private List<Integer> ninIds;

    private Integer lteId;

    private Integer gteId;

    private Integer ltId;

    private Integer gtId;

    private String lkName;

    private String nName;

    private String nnName;

}