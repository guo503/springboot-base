package com.tsyj.apollo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by gs on 2020/4/12.
 */
@Component
@ConfigurationProperties(prefix = "pay")
@Data
public class OrderProperties {

    /**
     * 支付超时时间
     */
    private Integer payTimeoutSeconds;

    /**
     * 支付频率
     */
    private Integer createFrequencySeconds;
}
