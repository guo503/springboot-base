package com.tsyj.controller;


import com.tsyj.enums.ErrorCodeEnum;
import com.tsyj.response.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @RequestMapping("/unAuth")
    public Result<Object> unAuth(){
        SecurityUtils.getSubject().logout();
        return Result.fail(ErrorCodeEnum.UNDEFINE_ERROR);
    }

    /**
     * 被踢出后跳转方法
     * @return
     */
    @RequestMapping("/kickOut")
    public Result<Object> kickOut(){
        return Result.fail(ErrorCodeEnum.INVALID_TOKEN);
    }
}
