package com.tsyj.advice;

import com.tsyj.consts.BErrorCode;
import com.tsyj.consts.IErrorCode;
import com.tsyj.exception.BizException;
import com.tsyj.exception.ServiceException;
import com.tsyj.response.Result;
import com.tsyj.utils.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * controller异常处理切面
 *
 * @author guos
 * @date 2018年1月12日
 */
@RestControllerAdvice
public class ControllerExceptionHandlerAdvice {

    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        // Result errorMessage
        String errorMessage = "server error";

        IErrorCode errorCode = null;
        if (e instanceof BizException) {
            BizException targetEx = (BizException) e;
            errorCode = targetEx.getErrorCode();
            errorMessage = targetEx.getMessage();
        } else if (e instanceof ServiceException) {
            ServiceException targetEx = (ServiceException) e;
            errorCode = targetEx.getErrorCode();
            errorMessage = targetEx.getMessage();
        } else if (e instanceof DuplicateKeyException) {
            errorCode = BErrorCode.DUPLICATE_KEY_ERROR;
            errorMessage = errorCode.getMessage();
        } else if (e instanceof UndeclaredThrowableException) {
            Throwable targetEx = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
            if (targetEx != null) {
                return Result.fail(targetEx.getMessage());
            }
        }
        String exceptionMsg = ExceptionUtils.getExceptionMsg(e);
        logger.error("{}", exceptionMsg);

        if (errorCode != null) {
            return Result.fail(errorCode);
        } else {
            return Result.fail(errorMessage);
        }
    }
}
