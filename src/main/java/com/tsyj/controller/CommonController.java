package com.tsyj.controller;


import com.tsyj.enums.ErrorCodeEnum;
import com.tsyj.response.Result;
import com.tsyj.utils.LocalFileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/common")
@RestController
public class CommonController {

    /**
     * 未授权跳转方法
     *
     * @return
     */
    @RequestMapping("/unAuth")
    public Result<Object> unAuth() {
        SecurityUtils.getSubject().logout();
        return Result.fail(ErrorCodeEnum.UNDEFINE_ERROR);
    }

    /**
     * 被踢出后跳转方法
     *
     * @return
     */
    @RequestMapping("/kickOut")
    public Result<Object> kickOut() {
        return Result.fail(ErrorCodeEnum.INVALID_TOKEN);
    }

    /**
     * 下载成功
     *
     * @return
     */
    @RequestMapping("/download")
    public Result<Object> download(HttpServletRequest request, HttpServletResponse response) {
        String filePath = "http://ac-dev.oss-cn-hangzhou.aliyuncs.com/20191223/466470a3-c219-4f6f-9505-a9501a5f5c7b.xlsx";
        LocalFileUtils.doExport(filePath, request, response);
        return Result.success("下载成功");
    }
}
