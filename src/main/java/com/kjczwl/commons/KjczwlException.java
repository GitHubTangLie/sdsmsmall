package com.kjczwl.commons;

/**
 * 自定义异常类型
 *
 * @author pyy
 **/
public class KjczwlException extends RuntimeException {

    public KjczwlException(Exception e) {
        super(e);
        this.code = 300;
    }

    public KjczwlException(String message) {
        super(message);
    }

    public KjczwlException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 错误代码
     */
    private int code;

    public int getCode() {
        return code;
    }

}
