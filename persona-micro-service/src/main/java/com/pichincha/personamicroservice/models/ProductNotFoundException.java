package com.pichincha.personamicroservice.models;

public class ProductNotFoundException extends RuntimeException {
 
    public ProductNotFoundException() {
        super();
    }
 
    public ProductNotFoundException(String message) {
        super(message);
    }
 
    public ProductNotFoundException(long id) {
        super("Product not found: " + id);
    }
}
