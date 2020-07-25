package com.tsyj.vo;

import com.tsyj.model.SysMenu;
import java.io.Serializable;
import lombok.Data;

/**
* 菜单表实体类
* @author guos
* @date 2020/07/24 16:57
*/
@Data
public class SysMenuVO extends SysMenu implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 228259419482477L;
}