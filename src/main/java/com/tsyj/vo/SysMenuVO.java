package com.tsyj.vo;

import com.tsyj.model.SysMenu;
import java.io.Serializable;
import lombok.Data;

/**
* 菜单表显示类
* @author guos
* @date 2020/12/14 17:43
*/
@Data
public class SysMenuVO extends SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 163584958485137L;
}