package com.dhhe.blog.common.exception;

public class BaseException extends Exception {

    private String message;

    private String errCode;

    public enum ExceptionType {
        USER_NOT_EXIST("用户不存在", "000001"),
        SESSION_TIMEOUT("会话超时", "000002"),
        FILE_UPLOAD_FAIL("文件上传失败", "000003"),
        NULL_PARAM("参数为空", "000004");

        private String message;

        private String code;

        ExceptionType(String message, String code) {
            this.message = message;
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public String getCode() {
            return this.code;
        }
    }

    public BaseException() {
    }

    public BaseException(ExceptionType type) {
        this.message = type.getMessage();
        this.errCode = type.getCode();
    }

    public BaseException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
