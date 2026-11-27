package pe.edu.isil.plaza_pagos_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import java.util.Map;

@RestControllerAdvice
public class DatabaseErrors {
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> conflicto() {
        return Map.of("error", "Datos duplicados, incompletos o referencia invalida");
    }
}
