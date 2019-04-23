package com.tsyj.aspect.impl;


import com.google.common.collect.Lists;
import com.tsyj.aspect.AbstractControllerAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * controller方法切面
 *
 * @author guos
 * @date 2018年1月30日
 */
@Aspect
@Component
@Order(0)
public class ControllerAspect extends AbstractControllerAspect {

    /**
     * 判断是否po,vo包的类
     *
     * @param
     * @return
     * @author guos
     * @date 2019/4/12 15:57
     **/
    @Override
    public List<String> getPackages() {
        return Lists.newArrayList("com.tsyj.po", "com.tsyj.vo");
    }

    /**
     * 切点
     *
     * @param
     * @return
     * @author guos
     * @date 2019/4/12 15:43
     **/
    @Pointcut("execution(* com.tsyj.controller..*.*(..))")
    public void pointcut() {
    }

}
