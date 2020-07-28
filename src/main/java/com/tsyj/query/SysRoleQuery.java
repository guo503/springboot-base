package com.tsyj.query;

import java.util.Date;
import lombok.Data;

/**
* 角色表查询条件类
* @author guos
* @date 2020/07/28 18:13
*/
@Data
public class SysRoleQuery {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 数据范围
     */
    private String dataScope;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 是否系统数据 0否 1是 默认0
     */
    private Byte isSys;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 是否启用 0 不启用 1启用
     */
    private Byte isUse;

    /**
     * 是否删除,0未删除 1已删除 默认0
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