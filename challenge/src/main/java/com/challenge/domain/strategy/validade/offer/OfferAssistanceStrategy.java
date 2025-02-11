package com.challenge.domain.strategy.validade.offer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.infra.exceptions.offer.OfferAssistanceException;

@Component("Offer Assistance")
public class OfferAssistanceStrategy implements OfferValidateStrategy {

	@Override
	public void validate(OfferDTO offer, QuoteDTO quote) {
		
		quote.assistances().forEach(var -> {
			
		  List<String> assistenceFind =	 offer.assistances().stream().filter(item -> item.equals(var)).collect(Collectors.toList());
		  
		  if(assistenceFind == null || assistenceFind.isEmpty()) {
			  throw new OfferAssistanceException();
		  }
			
		});
			
	}

}
