package com.tsyj.vo;

import com.tsyj.model.SysUserRole;
import java.io.Serializable;
import lombok.Data;

/**
* 用户-角色实体类
* @author guos
* @date 2020/07/24 16:57
*/
@Data
public class SysUserRoleVO extends SysUserRole implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 583656446936932L;
}