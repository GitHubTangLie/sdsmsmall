package com.kjczwl.config;

import com.kjczwl.commons.KjczwlException;
import com.kjczwl.commons.WrappedResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/***
* @Description: 全局异常处理器
* @Author: Mr.Tang
* @Date: 2022/10/9
*/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理 Exception 异常
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public WrappedResult<String> exceptionHandler(Exception e) {
        log.error("系统错误:", e);
        log.error(e.getMessage(), e);
        return WrappedResult.failedWrappedResult("系统错误请联系管理员");
    }


    /**
     * 处理 接口参数 在传入的参数类型不正确是 捕获异常  比如 代码定义的 int 传入的String
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public WrappedResult<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.error("参数类型和定义类型不匹配:", e);
        log.error(e.getMessage(), e);
        return WrappedResult.failedWrappedResult("参数类型和定义类型不匹配");
    }


    /**
     * 处理 BusinessException 异常
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = KjczwlException.class)
    public WrappedResult<String> businessExceptionHandler(KjczwlException e) {
        log.info("业务异常。code:{} , msg:{}", e.getCode(), e.getMessage());
        log.error(e.getMessage(), e);
        WrappedResult<String> result = WrappedResult.failedWrappedResult(e.getMessage());
        result.setCode(String.valueOf(e.getCode()));
        return result;
    }


    /**
     * IllegalArgumentException常用于校验参数错误，全局处理参数异常提示信息。
     *
     * @param e 异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public WrappedResult<String> businessExceptionHandler(IllegalArgumentException e) {
        log.info("参数异常。msg:" + e.getMessage());
        log.error(e.getMessage(), e);
        return WrappedResult.failedWrappedResult(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public WrappedResult<String> businessMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return WrappedResult.failedWrappedResult(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}