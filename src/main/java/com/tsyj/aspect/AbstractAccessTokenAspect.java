package com.tsyj.aspect;

import com.alibaba.fastjson.JSONObject;
import com.tsyj.annotation.AccessToken;
import com.tsyj.consts.BErrorCode;
import com.tsyj.consts.RedisConst;
import com.tsyj.exception.BizException;
import com.tsyj.thread.ReqThreadLocal;
import com.tsyj.utils.RedisUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;



/**
 *token切面抽象类
 * @author: guos
 * @date: 2019/4/12 16:01
 **/
public abstract class AbstractAccessTokenAspect {

    @Autowired
    protected RedisUtils redisUtils;
    /**
     * token失效时间，默认2周
     */
    private static final Long ACCESS_TOKEN_TTL = 3600 * 24 * 7L;


    /**
    *切点
     * @param
     * @author  guos
     * @date 2019/4/12 16:01
     * @return
     **/
    public abstract void pointcut();

    public abstract JSONObject getUser(String accessToken);

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        String accessToken = request.getHeader("access-token");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        boolean tokenRequired = false;

        Class<?> clazz = method.getDeclaringClass();
        AccessToken accessTokenAnnotation = null;

        // 先获取类注解
        if (clazz.isAnnotationPresent(AccessToken.class)) {
            accessTokenAnnotation = clazz.getAnnotation(AccessToken.class);
            tokenRequired = accessTokenAnnotation.required();
        }

        // 再获取方法注解
        if (method.isAnnotationPresent(AccessToken.class)) {
            accessTokenAnnotation = method.getAnnotation(AccessToken.class);
            tokenRequired = accessTokenAnnotation.required();
        }

        if (tokenRequired){
            //token为空
            if (StringUtils.isEmpty(accessToken)){
                throw new BizException(BErrorCode.ACCESS_TOKEN_ERROR);
            }
            JSONObject user = getUser(accessToken);
            if (user == null) {
                throw new BizException(BErrorCode.ACCESS_TOKEN_ERROR);
            }
        }
        if (!StringUtils.isEmpty(accessToken)) {
            JSONObject user = getUser(accessToken);
            if (user != null) {
                int userId = user.getIntValue("id");
                String userName = user.getString("name");
                ReqThreadLocal.setAccessToken(accessToken);
                ReqThreadLocal.setUserId(userId);
                ReqThreadLocal.setUserName(userName);
                // 刷新token过期时间
                redisUtils.expire(String.format(RedisConst.ACCESS_TOKEN, accessToken), ACCESS_TOKEN_TTL,
                        TimeUnit.SECONDS);
                redisUtils.expire(String.format(RedisConst.LOGIN_SYS, userId), ACCESS_TOKEN_TTL,
                        TimeUnit.SECONDS);
                return;
            }
        }

    }


}
