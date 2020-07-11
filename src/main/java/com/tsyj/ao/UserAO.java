package com.tsyj.ao;

import com.tsyj.model.User;
import java.io.Serializable;
import lombok.Data;

/**
* 用户实体类
* @author guos
* @date 2020/07/11 17:38
*/
@Data
public class UserAO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 738942333449289L;
}