package com.challenge.infra.exceptions;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException() {
        super("Produto não encontrado.");
    }

}
