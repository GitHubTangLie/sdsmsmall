/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
package com.kjczwl.commons;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/***
* @Description: 通用返回数据封装
* @Author: Mr.Tang
* @Date: 2022/10/9
*/
@ApiModel("通用的数据返回封装")
public class WrappedResult<T> {

    private static final String DEFAULT_INFOTYPE = "error";
    /**
     *
     */
    public static final String CODE_10001 = "10001";
    /**
     *
     */
    public static final String CODE_10002 = "10002";
    /**
     *
     */
    public static final String CODE_10003 = "10003";

    public WrappedResult() {
        type = "error";
    }

    public WrappedResult(boolean isSuccess, T data, String tip, String errorPage, String type) {
        this.type = "error";
        successful = isSuccess;
        resultValue = data;
        resultHint = tip;
        this.errorPage = errorPage;
        this.type = type;
    }

    public WrappedResult(boolean isSuccess, T data, String tip) {
        type = "error";
        successful = isSuccess;
        resultValue = data;
        resultHint = tip;
    }

    public WrappedResult(boolean isSuccess, T data, String tip, String code) {
        type = "error";
        successful = isSuccess;
        resultValue = data;
        resultHint = tip;
        this.code = code;
    }

    @ApiModelProperty("数据请求状态")
    private boolean successful;
    @ApiModelProperty("响应数据")
    private T resultValue;
    @ApiModelProperty("响应信息")
    private String resultHint;
    private String errorPage;
    private String type;

    private String code = "200";

    public static <T> WrappedResult<T> successWrapedResult(T data) {
        return new WrappedResult<T>(true, data, "", "", "");
    }

    public static <T> WrappedResult<T> successWrapedResult(T data, String resultHint) {
        return new WrappedResult<T>(true, data, resultHint, "", "");
    }

    public static <T> WrappedResult<T> successWrapedResult(String tip) {
        return new WrappedResult<T>(true, null, tip, "", "");
    }

    public static <T> WrappedResult<T> successResult() {
        return new WrappedResult<T>(true, null, "", "", "");
    }

    public static WrappedResult<String> failedWrappedResult(String exMessage) {
        return new WrappedResult<String>(false, "", exMessage);
    }

    public static <T> WrappedResult<T> failedWrappedDataResult(String exMessage, T data) {
        return new WrappedResult<T>(false, data, exMessage);
    }

    public static <T> WrappedResult<T> failedWrappedDataResult(String exMessage, T data, String code) {
        return new WrappedResult<T>(false, data, exMessage, code);
    }

    public static <T> WrappedResult<T> failedWrappedStringResult(Object object) {
        return new WrappedResult<T>(false, null, object.toString());
    }

    public static WrappedResult<String> failedWrappedResult(String exMessage, String errorPage) {
        return new WrappedResult<String>(false, "", exMessage, errorPage, "error");
    }

    public static WrappedResult<String> failedWrappedResult(String exMessage, String errorPage, String type) {
        return new WrappedResult<String>(false, "", exMessage, errorPage, type);
    }

    public static <T> WrappedResult<String> failedWrappedJsonResult(String jsonMessage, String errorPage, String type) {
        return new WrappedResult<String>(false, "", jsonMessage, errorPage, type);
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public T getResultValue() {
        return resultValue;
    }

    public void setResultValue(T resultValue) {
        this.resultValue = resultValue;
    }

    public String getResultHint() {
        return resultHint;
    }

    public void setResultHint(String resultHint) {
        this.resultHint = resultHint;
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}