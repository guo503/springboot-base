package com.tsyj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: guos
 * @date: 2018/11/6 0006
 */
@Service
public class RedisLockUtils {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtils redisUtil;

    /**
     * 加锁
     *
     * @param key   商品id
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (redisUtil.setIfAbsent(key, value)) {     //这个其实就是setnx命令，只不过在java这边稍有变化，返回的是boolen
            return true;
        }
        //避免死锁，且只让一个线程拿到锁
        String oldValue = String.valueOf(redisUtil.get(key)); //旧的值
        //如果锁过期了
        if (!StringUtils.isEmpty(oldValue) && Long.parseLong(oldValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String currentValue = String.valueOf(redisUtil.getAndSet(key, value));//新值

            //只会让一个线程拿到锁如果旧的value和currentValue相等，只会有一个线程达成条件，因为第二个线程拿到的oldValue已经和currentValue不一样了
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(oldValue)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = String.valueOf(redisUtil.get(key));
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisUtil.del(key);
            }
        } catch (Exception e) {
            logger.error("『redis分布式锁』解锁异常，{}", e);
        }
    }
}
