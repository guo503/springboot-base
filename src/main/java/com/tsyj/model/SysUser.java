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
* 用户表实体类
* @author guos
* @date 2020/12/14 17:43
*/
@Table(name = "sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 334461298188198L;

    /**
     * 编号
     */
    @Id()
    private Integer id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 是否可登录 0否 1是 默认1
     */
    private Byte isUse;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 是否删除，0未删除 1已删除 默认0
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

    public static final String LOGIN_NAME = "loginName";

    public static final String PASSWORD = "password";

    public static final String ROLE_ID = "roleId";

    public static final String NO = "no";

    public static final String NAME = "name";

    public static final String EMAIL = "email";

    public static final String PHONE = "phone";

    public static final String MOBILE = "mobile";

    public static final String PHOTO = "photo";

    public static final String LOGIN_IP = "loginIp";

    public static final String LOGIN_DATE = "loginDate";

    public static final String IS_USE = "isUse";

    public static final String REMARKS = "remarks";

    public static final String IS_DEL = "isDel";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATE_TIME = "updateTime";

    public static final String VERSIONS = "versions";
}