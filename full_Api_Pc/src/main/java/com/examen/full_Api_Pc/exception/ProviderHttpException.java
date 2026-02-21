package com.examen.full_Api_Pc.exception;

public class ProviderHttpException extends RuntimeException {
    private final int statusCode;
    private final String providerMessage;

    public ProviderHttpException(int statusCode, String providerMessage) {
        super(providerMessage);
        this.statusCode = statusCode;
        this.providerMessage = providerMessage;
    }

    public int getStatusCode() { return statusCode; }
    public String getProviderMessage() { return providerMessage; }
}