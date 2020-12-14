package com.tsyj.query;

import java.util.Date;
import lombok.Data;

/**
* 菜单表查询条件类
* @author guos
* @date 2020/12/14 17:43
*/
@Data
public class SysMenuQuery {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 父级编号
     */
    private Integer parentId;

    /**
     * 所有父级编号
     */
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 链接
     */
    private String href;

    /**
     * 目标
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否在菜单中显示: 0不显示 1显示
     */
    private Byte isShow;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 备注信息
     */
    private String remarks;

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