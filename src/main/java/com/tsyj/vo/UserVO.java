package com.tsyj.vo;

import com.tsyj.model.User;
import java.io.Serializable;
import lombok.Data;

/**
* 用户实体类
* @author guos
* @date 2020/07/25 10:42
*/
@Data
public class UserVO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 869187514943959L;
}