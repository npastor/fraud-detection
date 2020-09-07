package com.transaction.fraud.detection.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.transaction.fraud.detection.dto.ValidationErrorDto;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ValidationErrorDto> handleBindException(BindException exception) {
        return exception.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(e -> ValidationErrorDto.builder().field(e.getField()).message(e.getDefaultMessage()).build())
                        .collect(Collectors.toList());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ValidationErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(e -> ValidationErrorDto.builder().field(e.getField()).message(e.getDefaultMessage()).build())
                        .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ValidationErrorDto handleException(
                                               final Exception exception) {
        return ValidationErrorDto.builder().message("Something went wrong.").field(exception.getMessage()).build();
    }

}
