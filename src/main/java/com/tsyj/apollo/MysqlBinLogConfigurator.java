package com.tsyj.apollo;


import com.alibaba.fastjson.JSONArray;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.tsyj.config.MySqlHost;
import com.tsyj.config.MySqlHostProfile;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;

import java.util.List;


public class MysqlBinLogConfigurator implements ApplicationListener<ApplicationReadyEvent>, Ordered {
    // 只跑一次
    private static volatile boolean executed = false;

    private static final Object lock = new Object();

    /**
     * 默认namespace
     */
    private static final String MYSQL_BINLOG = "mysql-binlog";
    /**
     * 默认key
     */
    private static final String _HOSTS = "binlog.mysql.hosts";

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Config config = ConfigService.getConfig(MYSQL_BINLOG);
        if (config == null) {
            return;
        }
        ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MySqlHostProfile.class);
        // 注册bean
        beanFactory.registerBeanDefinition("com.tsyj.config.MySqlHostProfile", beanDefinitionBuilder.getRawBeanDefinition());
        MySqlHostProfile mySqlHostProfile = applicationContext.getBean(MySqlHostProfile.class);
        configure(mySqlHostProfile);
        // 保证只添加一次监听器
        synchronized (lock) {
            if (executed) {
                return;
            }
            config.addChangeListener(changeEvent -> {
                configure(mySqlHostProfile);
            });
            executed = true;
        }
    }

    private void configure(MySqlHostProfile mySqlHostProfile) {
        Config config = ConfigService.getConfig(MYSQL_BINLOG);
        if (config == null) {
            return;
        }
        String hosts = config.getProperty(_HOSTS, null);
        if (StringUtils.isEmpty(hosts)) {
            return;
        }
        try {
            //设置binlog服务器信息
            List<MySqlHost> mySqlHosts = JSONArray.parseArray(hosts, MySqlHost.class);
            mySqlHostProfile.setHosts(mySqlHosts);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
