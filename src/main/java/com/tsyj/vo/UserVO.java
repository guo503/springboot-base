package com.tsyj.vo;

import com.tsyj.po.User;
import java.io.Serializable;
import lombok.Data;

/**
* 用户实体类
* @author guos
* @date 2019/07/04 15:30
*/
@Data
public class UserVO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
}