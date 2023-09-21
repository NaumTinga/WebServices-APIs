package com.udacity.vehicles.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException(Long vehicleId) {
        super(String.format("Price not found with vehicleId %d", vehicleId));
    }
}
