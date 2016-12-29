package com.kind.common.client;

/**
 * Http 请求异常
 */
@SuppressWarnings("serial")
public class HttpClientRuntimeException extends RuntimeException {
    public HttpClientRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
