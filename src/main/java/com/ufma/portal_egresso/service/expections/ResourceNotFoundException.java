package com.ufma.portal_egresso.service.expections;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
    
}
