package com.sarvika.menagerie.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sarvika.menagerie.model.API_Error;
import com.sarvika.menagerie.model.Sex;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
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

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormatException(InvalidFormatException e) {

        API_Error api_error = null;

        if (Sex.class.toString().equals(e.getTargetType().toString())) {
            api_error = new API_Error();
            api_error.setStatus_code(400);
            api_error.setMessage("Invalid gender! Please choose 'm' or 'f'");

        }

        return new ResponseEntity(api_error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<Map<String, String>> handlePropertyReferenceException(PropertyReferenceException e) {

        API_Error api_error = new API_Error();
        api_error.setStatus_code(400);
        api_error.setMessage(e.getMessage());

        return new ResponseEntity(api_error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e) {

        API_Error api_error = new API_Error();
        api_error.setStatus_code(400);
        api_error.setMessage(e.getMessage());

        return new ResponseEntity(api_error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<API_Error> handleEntityNotFoundException(EntityNotFoundException e) {

        API_Error api_error = null;
        if (e.getMessage().contains("No enum constant org.springframework.data.domain.Sort.Direction")) {
            // Handle invalid sort direction
            api_error = new API_Error();
            api_error.setStatus_code(400);
            api_error.setMessage("Invalid input. Please type \"ASC\" or \"DESC\"");
        }

        return new ResponseEntity<>(api_error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputSexMismatchException.class)
    public ResponseEntity<API_Error> handleInputSexMismatchException(InputSexMismatchException e) {
        API_Error api_error = new API_Error();
        api_error.setStatus_code(400);
        api_error.setMessage(e.getMessage());

        return new ResponseEntity<>(api_error, HttpStatus.NOT_FOUND);
    }
}
