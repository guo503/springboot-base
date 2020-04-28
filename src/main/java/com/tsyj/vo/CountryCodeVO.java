package com.tsyj.vo;

import com.tsyj.model.CountryCode;
import java.io.Serializable;
import lombok.Data;

/**
* 国际电话号码区号实体类
* @author guos
* @date 2020/04/28 18:24
*/
@Data
public class CountryCodeVO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 961778298461453L;
}