package com.examen.full_Api_Pc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {

    record ApiError(String message) {}

    @ExceptionHandler(RucInvalidoException.class)
    public ResponseEntity<ApiError> handleRuc(RucInvalidoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiError(ex.getMessage()));
    }

    @ExceptionHandler(ProviderException.class)
    public ResponseEntity<ApiError> handleProvider(ProviderException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body(new ApiError(ex.getMessage()));
    }
    @ExceptionHandler(ProviderHttpException.class)
    public ResponseEntity<ApiError> handleProviderHttp(ProviderHttpException ex) {

        int sc = ex.getStatusCode();
        if (sc == 401) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiError("Token inválido o expirado (DECOLECTA_TOKEN)"));
        }
        if (sc >= 500) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(new ApiError("Proveedor no disponible, intente más tarde"));
        }

        return ResponseEntity.status(sc)
                .body(new ApiError(ex.getProviderMessage()));
    }
}
