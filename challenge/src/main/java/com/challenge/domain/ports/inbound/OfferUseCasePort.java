package com.challenge.domain.ports.inbound;

import java.util.Optional;

import com.challenge.domain.domains.QuoteDTO;

public interface OfferUseCasePort {
	
	Optional<Boolean> validateOffer(QuoteDTO quote);

}
