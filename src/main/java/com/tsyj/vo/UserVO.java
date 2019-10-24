package com.tsyj.vo;

import com.tsyj.model.User;
import java.io.Serializable;
import lombok.Data;

/**
* 用户实体类
* @author guos
* @date 2019/10/24 11:19
*/
@Data
public class UserVO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 765634791648267L;
}