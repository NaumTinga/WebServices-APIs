package com.udacity.vehicles.service;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MapsNotFoundException extends RuntimeException{

    public MapsNotFoundException() {
        super("Maps not found");
    }
}
