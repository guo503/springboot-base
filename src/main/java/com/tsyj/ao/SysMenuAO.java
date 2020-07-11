package com.tsyj.ao;

import com.tsyj.model.SysMenu;
import java.io.Serializable;
import lombok.Data;

/**
* 菜单表实体类
* @author guos
* @date 2020/07/11 17:24
*/
@Data
public class SysMenuAO extends SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 818193594165519L;
}