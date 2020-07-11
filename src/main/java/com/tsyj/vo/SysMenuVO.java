package com.tsyj.vo;

import com.tsyj.model.SysMenu;
import lombok.Data;

import java.io.Serializable;

/**
* 菜单表实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysMenuVO extends SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 543675745213643L;

    /**
     * 角色id
     */
    private Integer roleId;
}