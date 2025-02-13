package com.challenge.domain.strategy.validade.offer;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;

public interface OfferValidateStrategy {
	
	void validate(OfferDTO offer, QuoteDTO quote);

}
