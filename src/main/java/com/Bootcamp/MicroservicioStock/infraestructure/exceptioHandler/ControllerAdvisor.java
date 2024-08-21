package com.Bootcamp.MicroservicioStock.infraestructure.exceptioHandler;

import com.Bootcamp.MicroservicioStock.domain.exception.DescriptionTooLongException;
import com.Bootcamp.MicroservicioStock.domain.exception.NameIsTooLongException;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.CategoryAlreadyExistsException;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.CategoryNotFoundException;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.DescriptionNotFoundException;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    //AlreadyExist
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistsException(
            CategoryAlreadyExistsException categoryAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXISTS.getMessage()));
    }

    //NotFound
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(DescriptionNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDescriptionNotFoundException(
            DescriptionNotFoundException descriptionNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPTION_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_NOT_FOUND.getMessage()));
    }

    //TooLong
    @ExceptionHandler(DescriptionTooLongException.class)
    public ResponseEntity<Map<String, String>> handleDescriptionIsTooLongExeption(
            DescriptionTooLongException descriptionIsTooLongExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPTION_IS_TOO_LONG.getMessage()));
    }
    @ExceptionHandler(NameIsTooLongException.class)
    public ResponseEntity<Map<String, String>> handleNameIsTooLongExeption(
            NameIsTooLongException nameIsTooLongExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NAME_IS_TOO_LONG.getMessage()));
    }
}