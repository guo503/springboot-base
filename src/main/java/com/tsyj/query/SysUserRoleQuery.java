package com.tsyj.query;

import java.util.Date;
import lombok.Data;

/**
* 用户-角色查询条件类
* @author guos
* @date 2020/07/28 18:13
*/
@Data
public class SysUserRoleQuery {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 是否删除，0未删除，1已删除，默认0
     */
    private Byte isDel;

    /**
     * 创建人姓名
     */
    private String creator;

    /**
     * 修改人姓名
     */
    private String updater;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最近一次修改时间
     */
    private Date updateTime;

    /**
     * 版本号
     */
    private Integer versions;
}