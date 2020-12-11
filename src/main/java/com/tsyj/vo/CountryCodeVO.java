package com.tsyj.vo;

import com.tsyj.model.CountryCode;
import java.io.Serializable;
import lombok.Data;

/**
* 国际电话号码区号显示类
* @author guos
* @date 2020/12/11 19:55
*/
@Data
public class CountryCodeVO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 515879698393812L;
}