package com.tsyj.vo;

import com.tsyj.model.SysUser;
import java.io.Serializable;
import lombok.Data;

/**
* 用户表实体类
* @author guos
* @date 2020/07/24 16:57
*/
@Data
public class SysUserVO extends SysUser implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 872953262151518L;
}