package com.tsyj.ao;

import com.tsyj.model.CountryCode;
import lombok.Data;

import java.io.Serializable;

/**
* 国际电话号码区号实体类
* @author guos
* @date 2020/07/01 11:32
*/
@Data
public class CountryCodeAO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 113397563344737L;
}