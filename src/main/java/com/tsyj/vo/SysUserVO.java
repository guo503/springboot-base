package com.tsyj.vo;

import com.tsyj.model.SysUser;
import java.io.Serializable;
import lombok.Data;

/**
* 用户表实体类
* @author guos
* @date 2019/10/31 18:20
*/
@Data
public class SysUserVO extends SysUser implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 635715972334346L;
}