package com.challenge.domain.usecase;

import java.util.List;
import java.util.Optional;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.domain.ports.inbound.OfferUseCasePort;
import com.challenge.domain.ports.outbound.OfferAdapterPort;
import com.challenge.domain.strategy.validade.offer.OfferValidateStrategy;

public class OfferUseCase implements OfferUseCasePort{
	
	private final OfferAdapterPort offerPort;
	
	private final List<OfferValidateStrategy> listOfferValidateStrategies;

	public OfferUseCase(OfferAdapterPort offerPort, List<OfferValidateStrategy> listOfferValidateStrategies) {
		super();
		this.offerPort = offerPort;
		this.listOfferValidateStrategies = listOfferValidateStrategies;
	}

	@Override
	public Optional<Boolean> validateOffer(QuoteDTO quote) {
		
		OfferDTO offer = offerPort.findOfferByProduct(quote.productId());
		
		listOfferValidateStrategies.forEach(offerValidateStrategy -> offerValidateStrategy.validate(offer, quote));
		
		return Optional.empty();
	}

}
