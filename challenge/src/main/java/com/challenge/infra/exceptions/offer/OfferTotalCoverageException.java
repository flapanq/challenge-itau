package com.challenge.infra.exceptions.offer;

import org.springframework.stereotype.Component;

@Component("Offer Coverage Total Ex")
public class OfferTotalCoverageException extends RuntimeException {
	
	public OfferTotalCoverageException() {
        super("O valor total das coberturas não corresponde a somatória das coberturas informadas");
    }

}
