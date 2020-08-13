package com.nataraj.lib.exception.aem.ex;

public enum FrameworkExceptionConstant {
    NOT_FOUND_EXCEPTION(29000,"DATA_NOT_FOUND"),
    BAD_REQUEST_EXCEPTION(29001, "BAD_REQUEST"),
    UNKNOWN_EXCEPTION(30000,"SERVICE_NOT_AVAILABLE");

    public int code;
    public String message;
    private FrameworkExceptionConstant(int code, String message){
        this.code = code;
        this.message = message;
    }

}
