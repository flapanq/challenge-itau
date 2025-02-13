package com.challenge.infra.exceptions.offer;

import org.springframework.stereotype.Component;

@Component("Offer Max Min Ex")
public class OfferMaxMinException extends RuntimeException {
	
	public OfferMaxMinException() {
        super("Prêmio mensal fora do máximo e mínimo definido para a oferta.");
    }

}
