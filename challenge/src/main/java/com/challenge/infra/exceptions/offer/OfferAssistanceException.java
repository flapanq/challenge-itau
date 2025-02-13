package com.challenge.infra.exceptions.offer;

import org.springframework.stereotype.Component;

@Component("Offer Assistance Ex")
public class OfferAssistanceException extends RuntimeException {
	
	public OfferAssistanceException() {
        super("Assitencia não válida.");
    }

}
