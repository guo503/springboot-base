package com.tsyj.utils;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

;

/**
 * @description:
 * @author: guos
 * @date: 2018/11/6 0006
 */
@Service
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtils() {
    }


    /**
     * 把对象放入Hash中
     */
    public void hset(String key, String field, Object o) {
        redisTemplate.opsForHash().put(key, field, JsonUtils.objectToJson(o));

    }

    /**
     * 从Hash中获取对象
     */
    public String hget(String key, String field) {
        Object val = redisTemplate.opsForHash().get(key, field);
        if (StringUtils.isEmpty(val)) {
            return null;
        }
        return val.toString();
    }

    /**
     * 从Hash中获取对象,转换成制定类型
     */
    public <T> T hget(String key, String field, Class<T> clazz) {
        String text = hget(key, field);
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        return JsonUtils.jsonToPojo(text, clazz);
    }

    /**
     * 从Hash中删除对象
     */
    public long hdel(String key, Object... field) {
        return redisTemplate.opsForHash().delete(key, field);
    }


    /**
     * 自增操作
     *
     * @param key
     * @param step
     * @return
     */
    public long incrBy(String key, long step) {
        return redisTemplate.opsForValue().increment(key, step);
    }

    /**
     * 添加key
     *
     * @param key
     * @param value
     * @return
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取key
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取key,并设置新值
     *
     * @param key
     * @param value
     * @return
     */
    public Object getAndSet(String key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }


    /**
     * 删除key
     *
     * @param key
     * @return
     */
    public void del(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }


    /**
     * 设置过期时间
     *
     * @param key
     * @param timeout
     * @return
     * @author guos
     * @date 2019/4/3 13:03
     **/
    public Boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }


    /**
     * 设置过期时间
     *
     * @param key
     * @param timeout
     * @param timeUtit
     * @return
     * @author guos
     * @date 2019/4/3 13:03
     **/
    public Boolean expire(String key, long timeout, TimeUnit timeUtit) {
        return redisTemplate.expire(key, timeout, timeUtit);
    }


    /**
     * 设置过期时间
     *
     * @param key
     * @param date
     * @return
     * @author guos
     * @date 2019/4/3 13:03
     **/
    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }


    /**
     * 返回给定 key 的剩余生存时间,以秒为单位
     *
     * @param key
     * @return
     * @author guos
     * @date 2019/4/3 13:02
     **/
    public Long ttl(String key) {
        return redisTemplate.getExpire(key);
    }


    /**
     * @param key
     * @param value
     * @return
     */
    public boolean setIfAbsent(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public RedisSerializer<?> getDefaultSerializer() {
        return this.redisTemplate.getDefaultSerializer();
    }

    public RedisSerializer<?> getStringSerializer() {
        return this.redisTemplate.getStringSerializer();
    }

    public RedisSerializer<?> getValueSerializer() {
        return this.redisTemplate.getValueSerializer();
    }
}
