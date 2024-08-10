package com.sarvika.menagerie.exception;

import com.sarvika.menagerie.model.API_Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String defaultMessage = err.getDefaultMessage();
            String field = ((FieldError) err).getField();

            response.put(field, defaultMessage);
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<API_Error> handleEntityNotFoundException(EntityNotFoundException e) {
        API_Error api_error = new API_Error();
        api_error.setStatus_code(400);
        api_error.setMessage(e.getMessage());

        return new ResponseEntity<>(api_error, HttpStatus.NOT_FOUND);
    }
}
