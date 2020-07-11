package com.tsyj.ao;

import com.tsyj.model.SysRoleMenu;
import java.io.Serializable;
import lombok.Data;

/**
* 角色-菜单实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysRoleMenuAO extends SysRoleMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 499146164495296L;
}