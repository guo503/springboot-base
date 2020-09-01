package com.tsyj.vo;

import com.tsyj.model.User;
import lombok.Data;

import java.io.Serializable;

/**
* 用户显示类
* @author guos
* @date 2020/07/28 16:16
*/
@Data
public class UserVO extends User implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 651436811964537L;


    private String phone1;

    private String phone2;

    private String phone3;
}