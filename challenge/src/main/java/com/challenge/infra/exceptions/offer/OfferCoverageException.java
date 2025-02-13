package com.challenge.infra.exceptions.offer;

import org.springframework.stereotype.Component;

@Component("Offer Coverage Ex")
public class OfferCoverageException extends RuntimeException {
	
	public OfferCoverageException() {
        super("Cobertura não válida.");
    }

}
