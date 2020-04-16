package com.tsyj.apollo;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.tsyj.utils.ContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 设置apollo参数
 *
 * @author rachel
 * @data 2020/01/16
 */
public class ApolloArgsRunListener implements SpringApplicationRunListener, Ordered {

    // 只跑一次
    private static volatile boolean executed = false;

    private static final Object lock = new Object();

    public ApolloArgsRunListener(SpringApplication application, String[] args) {
        ContextUtils.setApplication(application);
    }

    @Override
    public void starting() {
        synchronized (lock) {
            if (executed) {
                return;
            }

            // 先从System Property（服务器上部署）
            Properties properties = System.getProperties();
            String appId = properties.getProperty("app.id");
            String env = properties.getProperty("env");
            if (appId == null || env == null) {
                // 再从application.yml（本地开发用）
                try {
                    JSONObject yml = this.readYml();
                    JSONObject app = yml.getJSONObject("app");
                    appId = appId == null ? app.getString("id") : appId;
                    env = env == null ? app.getString("env") : env;
                    System.setProperty("app.id", appId);
                    System.setProperty("env", env);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("application.yml read error");
                }
            }
            init();
            executed = true;
        }
    }

    /**
     * 读取apollo application
     */
    private void init() {
        System.out.println("----------->apollo 预读取");
        Config c = ConfigService.getAppConfig();
        String namespaces = c.getProperty("namespaces",null);
        ConfigContext.setApplication(namespaces.split(","));
    }


    private JSONObject readYml() throws IOException {
        String location = "/application.yml";
        Yaml yaml = new Yaml();
        //MailConfig 这个是这个主函数所在的类的类名
        InputStream input = new ClassPathResource(location).getInputStream();
        //加载流,获取yaml文件中的配置数据，然后转换为Map，
        Map content = (Map)yaml.load(input);
        JSONObject yml=new JSONObject();
        Iterator it = content.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            yml.put(key, content.get(key));
        }
        return yml;
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {

    }

    @Override
    public int getOrder() {
        return -5;
    }

}
