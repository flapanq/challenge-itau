package com.challenge.domain.ports.outbound;

import java.util.UUID;

import com.challenge.domain.domains.OfferDTO;

public interface OfferAdapterPort {
	
	OfferDTO findOfferByProduct(UUID productId);

}
