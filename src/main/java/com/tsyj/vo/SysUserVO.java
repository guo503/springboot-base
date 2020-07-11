package com.tsyj.vo;

import com.tsyj.model.SysUser;
import java.io.Serializable;
import lombok.Data;

/**
* 用户表实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysUserVO extends SysUser implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 486484555164421L;
}