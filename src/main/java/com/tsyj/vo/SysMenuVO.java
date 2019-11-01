package com.tsyj.vo;

import com.tsyj.model.SysMenu;
import lombok.Data;

import java.io.Serializable;

/**
* 菜单表实体类
* @author guos
* @date 2019/10/31 18:20
*/
@Data
public class SysMenuVO extends SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 211561513677946L;

    private Integer roleId;
}