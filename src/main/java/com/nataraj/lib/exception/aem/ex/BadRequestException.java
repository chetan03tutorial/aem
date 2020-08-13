package com.nataraj.lib.exception.aem.ex;

public class BadRequestException extends BaseFrameworkException {

    public BadRequestException(int code, String message) {
        super(code, message);
    }

    public BadRequestException(String message) {
        this(FrameworkExceptionConstant.BAD_REQUEST_EXCEPTION.code, message);
    }

    public BadRequestException(String message, Throwable th) {
        super(message, th);
    }
}
