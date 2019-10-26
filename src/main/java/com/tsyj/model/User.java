package com.tsyj.model;

import com.tsyj.page.Page;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import mybatis.core.annotation.Id;
import mybatis.core.annotation.Table;

/**
* 用户实体类
* @author guos
* @date 2019/10/26 14:30
*/
@Table(name = "user")
@Data
public class User extends Page implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 823943563559863L;

    /**
     * id
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
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updater;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 乐观锁
     */
    private Integer version;

    
    
    
    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String CREATOR = "creator";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATER = "updater";

    public static final String UPDATE_TIME = "updateTime";

    public static final String VERSION = "version";
}