package com.tsyj.vo;

import com.tsyj.model.SysUser;
import java.io.Serializable;
import lombok.Data;

/**
* 用户表显示类
* @author guos
* @date 2020/07/28 18:13
*/
@Data
public class SysUserVO extends SysUser implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 868147627826342L;
}