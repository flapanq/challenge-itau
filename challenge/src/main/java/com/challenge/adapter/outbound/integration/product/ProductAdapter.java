package com.challenge.adapter.outbound.integration.product;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.ProductDTO;
import com.challenge.domain.ports.outbound.OfferAdapterPort;
import com.challenge.domain.ports.outbound.ProductAdapterPort;
import com.challenge.infra.exceptions.ProductNotFoundException;

@Component
public class ProductAdapter implements ProductAdapterPort {
	
	private final ProductClient productClient;

	public ProductAdapter(ProductClient productClient) {
		super();
		this.productClient = productClient;
	}

	@Override
	public ProductDTO findById(UUID id) {
		try {
			return productClient.findProduct(id);
		} catch (Exception e) {
			throw new ProductNotFoundException();
		}
	}

	

}
