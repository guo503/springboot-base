package com.tsyj.vo;

import com.tsyj.model.CountryCode;
import java.io.Serializable;
import lombok.Data;

/**
* 国际电话号码区号显示类
* @author guos
* @date 2020/07/28 18:25
*/
@Data
public class CountryCodeVO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 837412167479571L;
}