package br.com.ada.party.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerAdvice {

//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public ResponseEntity partyInvalidException(WebRequest request) {
//        return ResponseEntity.badRequest().body("Argumentos invalidos informados");
//    }
    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity entityNotFound(WebRequest request) {
        return ResponseEntity.notFound().build();
    }

}
