package com.tsyj.vo;

import com.tsyj.model.SysUserRole;
import java.io.Serializable;
import lombok.Data;

/**
* 用户-角色显示类
* @author guos
* @date 2020/07/28 18:13
*/
@Data
public class SysUserRoleVO extends SysUserRole implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 649616426844158L;
}