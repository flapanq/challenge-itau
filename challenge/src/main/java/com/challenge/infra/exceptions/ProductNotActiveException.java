package com.challenge.infra.exceptions;

import org.springframework.stereotype.Component;

@Component("Product Not Active")
public class ProductNotActiveException extends RuntimeException {
	
	public ProductNotActiveException() {
        super("Produto não ativo.");
    }

}
