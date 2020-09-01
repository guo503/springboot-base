package com.tsyj.vo;

import com.tsyj.model.CountryCode;
import lombok.Data;

import java.io.Serializable;

/**
* 国际电话号码区号显示类
* @author guos
* @date 2020/08/15 11:19
*/
@Data
public class CountryCodeVO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 175258568864776L;
}