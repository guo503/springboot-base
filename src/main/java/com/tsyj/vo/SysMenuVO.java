package com.tsyj.vo;

import com.tsyj.model.SysMenu;
import java.io.Serializable;
import lombok.Data;

/**
* 菜单表显示类
* @author guos
* @date 2020/07/28 18:13
*/
@Data
public class SysMenuVO extends SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 442868442635745L;
}