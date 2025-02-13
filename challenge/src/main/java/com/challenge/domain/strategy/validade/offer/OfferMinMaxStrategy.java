package com.challenge.domain.strategy.validade.offer;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.infra.exceptions.offer.OfferMaxMinException;

@Component("Offer Min Max")
public class OfferMinMaxStrategy implements OfferValidateStrategy {

	@Override
	public void validate(OfferDTO offer, QuoteDTO quote) {
		
		if(!(quote.totalMonthlyPremiumAmount().compareTo(offer.monthlyPremiumAmount().minAmount()) > 0 
				&& quote.totalMonthlyPremiumAmount().compareTo(offer.monthlyPremiumAmount().maxAmount()) < 0)){
			throw new OfferMaxMinException();
		}
			
	}

}
