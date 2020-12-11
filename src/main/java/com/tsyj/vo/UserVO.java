package com.tsyj.vo;

import com.tsyj.model.User;
import java.io.Serializable;
import lombok.Data;

/**
* 用户显示类
* @author guos
* @date 2020/12/11 19:55
*/
@Data
public class UserVO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 424394233989676L;
}