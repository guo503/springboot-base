package com.tsyj.ao;

import com.tsyj.model.CountryCode;
import java.io.Serializable;
import lombok.Data;

/**
* 国际电话号码区号实体类
* @author guos
* @date 2020/05/20 13:49
*/
@Data
public class CountryCodeAO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 572883222885524L;
}