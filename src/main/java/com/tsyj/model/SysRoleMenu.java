package com.tsyj.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import mybatis.core.annotation.Id;
import mybatis.core.annotation.Table;

/**
* 角色-菜单实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Table(name = "sys_role_menu")
@Data
public class SysRoleMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 997187474557593L;

    /**
     * 编号
     */
    @Id()
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

    
    
    
    public static final String ID = "id";

    public static final String ROLE_ID = "roleId";

    public static final String MENU_ID = "menuId";

    public static final String IS_DEL = "isDel";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATE_TIME = "updateTime";

    public static final String VERSIONS = "versions";
}