package com.tsyj.model;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mybatis.core.annotation.Id;
import mybatis.core.annotation.LogicDelete;
import mybatis.core.annotation.Table;

/**
* 角色表实体类
* @author guos
* @date 2020/12/14 17:43
*/
@Table(name = "sys_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRole implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 786883993483781L;

    /**
     * 编号
     */
    @Id()
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

    public static final String NAME = "name";

    public static final String EN_NAME = "enName";

    public static final String DATA_SCOPE = "dataScope";

    public static final String ROLE_TYPE = "roleType";

    public static final String IS_SYS = "isSys";

    public static final String REMARKS = "remarks";

    public static final String IS_USE = "isUse";

    public static final String IS_DEL = "isDel";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATE_TIME = "updateTime";

    public static final String VERSIONS = "versions";
}