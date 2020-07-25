package com.tsyj.query;

import lombok.Data;

import java.util.Date;

/**
* 角色-菜单实体类
* @author guos
* @date 2020/07/24 16:57
*/
@Data
public class SysRoleMenuQuery {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 菜单编号
     */
    private Integer menuId;

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