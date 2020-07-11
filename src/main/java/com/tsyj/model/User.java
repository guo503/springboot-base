package com.tsyj.model;

import lombok.Data;
import mybatis.core.annotation.Id;
import mybatis.core.annotation.LogicDelete;
import mybatis.core.annotation.Table;
import mybatis.core.annotation.Version;

import java.io.Serializable;
import java.util.Date;

/**
* 用户实体类
* @author guos
* @date 2020/07/11 17:38
*/
@Table(name = "user")
@Data
public class User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 167112978858259L;

    /**
     * 编号
     */
    @Id()
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
    @Version()
    private Integer version;

    
    
    
    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String IS_DEL = "isDel";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATE_TIME = "updateTime";

    public static final String VERSION = "version";
}