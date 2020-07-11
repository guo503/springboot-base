package com.tsyj.ao;

import com.tsyj.model.SysUser;
import java.io.Serializable;
import lombok.Data;

/**
* 用户表实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysUserAO extends SysUser implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 767375548262246L;
}