package com.tsyj.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mybatis.core.annotation.Id;
import mybatis.core.annotation.LogicDelete;
import mybatis.core.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
* 菜单表实体类
* @author guos
* @date 2020/07/24 16:57
*/
@Table(name = "sys_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 283379755231544L;

    /**
     * 编号
     */
    @Id()
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
    @LogicDelete()
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

    
    
    
    public static final String ID = "id";

    public static final String PARENT_ID = "parentId";

    public static final String PARENT_IDS = "parentIds";

    public static final String NAME = "name";

    public static final String SORT_NO = "sortNo";

    public static final String HREF = "href";

    public static final String TARGET = "target";

    public static final String ICON = "icon";

    public static final String IS_SHOW = "isShow";

    public static final String PERMISSION = "permission";

    public static final String REMARKS = "remarks";

    public static final String IS_DEL = "isDel";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATE_TIME = "updateTime";

    public static final String VERSIONS = "versions";
}