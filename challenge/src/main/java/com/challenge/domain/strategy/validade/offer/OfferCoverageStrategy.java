package com.challenge.domain.strategy.validade.offer;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.infra.exceptions.offer.OfferAssistanceException;

@Component("Offer Coverage")
public class OfferCoverageStrategy implements OfferValidateStrategy {

	@Override
	public void validate(OfferDTO offer, QuoteDTO quote) {
		
		quote.coverages().forEach((key, tab) -> {
			
			BigDecimal val = offer.coverages().get(key);
			
			if(val == null || tab.compareTo(val) == 1) {
				throw new OfferAssistanceException();
			}
			
		});
			
	}

}
