package com.example.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoPedidoException.class)
    public ResponseEntity<String> handleValidacaoPedidoException(ValidacaoPedidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
} 