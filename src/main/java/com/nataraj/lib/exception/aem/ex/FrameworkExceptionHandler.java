package com.nataraj.lib.exception.aem.ex;

import java.time.LocalDateTime;

public class FrameworkExceptionHandler {

    public FrameworkExceptionHandler(){

    }

    public FrameworkErrorResponse handleException(BaseFrameworkException ex){
        FrameworkErrorResponse errorResponse = buildErrorResponse(ex);
        ResponseHttpStatus status = ex.getClass().getAnnotation(ResponseHttpStatus.class);
        errorResponse.setHttpStatus(status.value());
        return errorResponse;
    }


    public FrameworkErrorResponse handleException(Exception ex){
        ServiceUnavailableException suvException = new ServiceUnavailableException(
                FrameworkExceptionConstant.UNKNOWN_EXCEPTION.code,
                FrameworkExceptionConstant.UNKNOWN_EXCEPTION.message);
        FrameworkErrorResponse errorResponse = buildErrorResponse(suvException);
        ResponseHttpStatus status = ex.getClass().getAnnotation(ResponseHttpStatus.class);
        errorResponse.setHttpStatus(status.value());
        return errorResponse;
    }

    private FrameworkErrorResponse buildErrorResponse(BaseFrameworkException ex){
        FrameworkErrorResponse error = new FrameworkErrorResponse();
        error.setCode(ex.getErrorCode());
        error.setMessage(ex.getErrorMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setRootCause(ex.getCause().getMessage());
        return error;
    }

    @ResponseHttpStatus(503)
    private class ServiceUnavailableException extends BaseFrameworkException{

        public ServiceUnavailableException(int code, String message) {
            super(code, message);
        }

        public ServiceUnavailableException(String message, Throwable th) {
            super(message, th);
        }
    }
}
