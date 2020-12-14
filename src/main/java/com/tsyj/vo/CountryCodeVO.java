package com.tsyj.vo;

import com.tsyj.model.CountryCode;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 国际电话号码区号显示类
* @author guos
* @date 2020/12/12 16:28
*/
@EqualsAndHashCode(callSuper = false)
@Data
public class CountryCodeVO extends CountryCode implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 783448326714263L;
}