package com.tsyj.query;

import lombok.Data;

import java.util.List;

/**
* 用户查询条件类
* @author guos
* @date 2020/07/28 16:16
*/
@Data
public class UserQuery {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否删除，0未删除，1已删除，默认0
     */
    private Byte isDel;

    /**
     * 创建人姓名
     */
    private String creator;

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

    private String idSort;

    private String isDelSort;


}