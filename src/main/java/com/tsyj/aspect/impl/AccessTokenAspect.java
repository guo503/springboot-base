package com.tsyj.aspect.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsyj.aspect.AbstractAccessTokenAspect;
import com.tsyj.constant.RedisConstant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * controller方法切面
 *
 * @author: guos
 * @date: 2019/4/15 20:28
 **/
@Order(2)
@Aspect
@Component
public class AccessTokenAspect extends AbstractAccessTokenAspect {

    @Pointcut("execution(* com.tsyj.*.controller*..*.*(..))")
    @Override
    public void pointcut() {
        // do noting
    }

    @Override
    public JSONObject getUser(String accessToken) {
        Object user = redisUtils.get(String.format(RedisConstant.ACCESS_TOKEN, accessToken));
        if (user != null) {
            return (JSONObject) JSON.toJSON(user);
        }
        return null;
    }

}
