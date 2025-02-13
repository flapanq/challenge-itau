package com.challenge.domain.strategy.validade.product;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.ProductDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.infra.exceptions.ProductNotActiveException;

@Component("Product Active")
public class ProductActiveStrategy implements ProductValidateStrategy {

	@Override
	public void validate(ProductDTO product, QuoteDTO quote) {
		
		if(product.active().equals(false)) {
			throw new ProductNotActiveException();
		}
		
	}

}
