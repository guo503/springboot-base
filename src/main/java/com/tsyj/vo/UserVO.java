package com.tsyj.vo;

import com.tsyj.model.User;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 用户显示类
* @author guos
* @date 2020/12/12 16:28
*/
@EqualsAndHashCode(callSuper = false)
@Data
public class UserVO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 566484174756264L;
}