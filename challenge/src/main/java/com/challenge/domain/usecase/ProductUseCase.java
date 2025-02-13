package com.challenge.domain.usecase;

import java.util.List;
import java.util.Optional;

import com.challenge.domain.domains.ProductDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.domain.ports.inbound.ProductUseCasePort;
import com.challenge.domain.ports.outbound.ProductAdapterPort;
import com.challenge.domain.strategy.validade.product.ProductValidateStrategy;

public class ProductUseCase implements ProductUseCasePort{
	
	private final ProductAdapterPort productAdapterPort;
	
	private List<ProductValidateStrategy> listProductValidates;

	public ProductUseCase(ProductAdapterPort productAdapterPort, List<ProductValidateStrategy> listProductValidates) {
		super();
		this.productAdapterPort = productAdapterPort;
		this.listProductValidates = listProductValidates;
	}

	@Override
	public Optional<Boolean> validateProduct(QuoteDTO quote) {
		
		ProductDTO product =  productAdapterPort.findById(quote.productId());
		
		listProductValidates.forEach(productValidate -> productValidate.validate(product, quote));
		
		
		return Optional.of(true);
	}

}
