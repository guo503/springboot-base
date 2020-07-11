package com.tsyj.ao;

import com.tsyj.model.SysRole;
import java.io.Serializable;
import lombok.Data;

/**
* 角色表实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysRoleAO extends SysRole implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 656528523814869L;
}