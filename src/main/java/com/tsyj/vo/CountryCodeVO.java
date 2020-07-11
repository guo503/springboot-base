package com.tsyj.vo;

import com.tsyj.model.CountryCode;
import lombok.Data;

import java.io.Serializable;

/**
* 国际电话号码区号实体类
* @author guos
* @date 2020/07/11 16:56
*/
@Data
public class CountryCodeVO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 671268681492843L;
}