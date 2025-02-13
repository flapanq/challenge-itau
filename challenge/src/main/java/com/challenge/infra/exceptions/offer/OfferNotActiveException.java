package com.challenge.infra.exceptions.offer;

import org.springframework.stereotype.Component;

@Component("Offer Not Active")
public class OfferNotActiveException extends RuntimeException {
	
	public OfferNotActiveException() {
        super("Oferta não ativa.");
    }

}
