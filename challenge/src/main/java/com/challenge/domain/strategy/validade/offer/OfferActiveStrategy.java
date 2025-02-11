package com.challenge.domain.strategy.validade.offer;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.infra.exceptions.offer.OfferNotActiveException;

@Component("Offer Active")
public class OfferActiveStrategy implements OfferValidateStrategy {

	@Override
	public void validate(OfferDTO offer, QuoteDTO quote) {
		
		if(offer.active().equals(false)) {
			throw new OfferNotActiveException();
		}
		
	}

}
