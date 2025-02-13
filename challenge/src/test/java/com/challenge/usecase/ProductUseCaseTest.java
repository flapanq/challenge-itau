package com.challenge.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.builder.BuilderProduct;
import com.challenge.builder.BuilderQuote;
import com.challenge.domain.ports.outbound.ProductAdapterPort;
import com.challenge.domain.strategy.validade.product.ProductActiveStrategy;
import com.challenge.domain.strategy.validade.product.ProductValidateStrategy;
import com.challenge.domain.usecase.ProductUseCase;

@SpringBootTest
public class ProductUseCaseTest {

	@Mock
	private ProductAdapterPort productAdapterPort;

	private ProductUseCase productUseCase;
	
	@BeforeEach
	void setup() {
		List<ProductValidateStrategy> listProductValidates = new ArrayList<>();
		ProductValidateStrategy  productValidateStrategy = new ProductActiveStrategy();
		listProductValidates.add(productValidateStrategy);
		productUseCase = new ProductUseCase(productAdapterPort,listProductValidates );
	}
	
	
	 @Test()
	public void testActiveProduct() {
		
		try {
			when(productAdapterPort.findById(any())).thenReturn(BuilderProduct.build());
			productUseCase.validateProduct(BuilderQuote.buildDTO());
		}catch (Exception e) {
			assertEquals(e.getMessage(),"Produto não ativo.");
		}
		
		
	}


}
