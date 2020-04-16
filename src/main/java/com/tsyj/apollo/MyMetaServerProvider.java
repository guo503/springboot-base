package com.tsyj.apollo;

import com.ctrip.framework.apollo.core.enums.Env;
import com.ctrip.framework.apollo.core.spi.MetaServerProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyMetaServerProvider implements MetaServerProvider {

    private static final int ORDER = MetaServerProvider.HIGHEST_PRECEDENCE;

    private static final String DEV_URL = "http://115.29.231.136:9080";

    private static final String TEST_URL = "http://115.29.231.136:9080/test";

    private static final String PRE_URL = "http://115.29.231.136:9080/pre";

    private static final String PROD_URL = "http://115.29.231.136:9080/prod";

    private static final Map<String, String> domains = new HashMap<>();

    static {
        domains.put("dev", DEV_URL);
        domains.put("test", TEST_URL);
        domains.put("pre", PRE_URL);
        domains.put("prod", PROD_URL);
    }

    public MyMetaServerProvider() {

    }

    @Override
    public String getMetaServerAddress(Env env) {
        Properties properties = System.getProperties();
        String _env = properties.getProperty("env");
        String domain = null;
        if (_env == null || (domain = domains.get(_env.toLowerCase())) == null) {
            // 如果环境非dev,test,pre,prod,返回无效的地址
            return "http://apollo.meta";
        }
        return domain;
    }

    @Override
    public int getOrder() {
        return ORDER;
    }
}
