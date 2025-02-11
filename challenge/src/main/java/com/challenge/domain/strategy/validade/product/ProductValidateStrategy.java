package com.challenge.domain.strategy.validade.product;

import com.challenge.domain.domains.ProductDTO;
import com.challenge.domain.domains.QuoteDTO;

public interface ProductValidateStrategy {
	
	void validate(ProductDTO product, QuoteDTO quote);

}
