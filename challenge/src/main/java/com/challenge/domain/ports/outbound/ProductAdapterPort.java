package com.challenge.domain.ports.outbound;

import java.util.UUID;

import com.challenge.domain.domains.ProductDTO;

public interface ProductAdapterPort {
	
	ProductDTO findById(UUID id);

}
