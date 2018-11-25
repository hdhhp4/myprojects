package com.dhhe.demo.exception;

/**
 * 自定义异常
 *
 * @author Administrator
 */
public class MyException extends Exception {

    public enum ExCode {
        normal("000000"),
        sessionTimeout("000001"),
        loginErr("000002");

        private String code;

        ExCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

    @SuppressWarnings("unused")
    private String errorCode;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MyException() {
        super();
        this.errorCode = ExCode.normal.getCode();
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = code;
    }

    public MyException(String message, Throwable cause, String code) {
        super(message, cause);
        this.errorCode = code;
    }

    public MyException(String message, String code) {
        super(message);
        this.errorCode = code;
    }

    public MyException(Throwable cause, String code) {
        super(cause);
        this.errorCode = code;
    }


}
