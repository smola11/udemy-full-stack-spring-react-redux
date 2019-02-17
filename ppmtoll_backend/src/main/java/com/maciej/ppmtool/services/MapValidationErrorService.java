package com.maciej.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    // Helps us if we are getting a valid object - if the client is passing a valid object; @Columns is database constraint;
    // This service has no way to check the database constraints;
    public ResponseEntity<?> mapValidation(BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
