package com.nataraj.lib.exception.aem.ex;


public class DataNotFoundException extends BaseFrameworkException {

    public DataNotFoundException(int code, String message) {
        super(code, message);
    }

    public DataNotFoundException(String message) {
        this(FrameworkExceptionConstant.NOT_FOUND_EXCEPTION.code, message);
    }

    public DataNotFoundException(String message, Throwable th) {
        super(message, th);
    }
}
