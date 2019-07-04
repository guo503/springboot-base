package com.tsyj.cond;

import com.tsyj.page.Page;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* 用户查询条件类
* @author guos
* @date 2019/07/04 15:32
*/
@Data
public class UserCond extends Page implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
    *上一次最大id
    */
    private Integer gtId;

    /**
     * id
     */
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
}