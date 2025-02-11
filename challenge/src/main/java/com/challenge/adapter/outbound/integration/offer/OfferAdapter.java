package com.challenge.adapter.outbound.integration.offer;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.ports.outbound.OfferAdapterPort;

@Component
public class OfferAdapter implements OfferAdapterPort {
	
	private final OfferClient offerClient;

	public OfferAdapter(OfferClient offerClient) {
		super();
		this.offerClient = offerClient;
	}

	@Override
	public OfferDTO findOfferByProduct(UUID productId) {

		try {
			return offerClient.findOfferByProduct(productId);
		} catch (Exception e) {
			
		}
		return null;

	}

}
