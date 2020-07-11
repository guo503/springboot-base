package com.tsyj.vo;

import com.tsyj.model.SysUserRole;
import java.io.Serializable;
import lombok.Data;

/**
* 用户-角色实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysUserRoleVO extends SysUserRole implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 283554523157718L;
}