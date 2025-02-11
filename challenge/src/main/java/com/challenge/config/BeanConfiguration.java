package com.challenge.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenge.adapter.outbound.integration.kafka.QuoteProducer;
import com.challenge.adapter.outbound.integration.offer.OfferAdapter;
import com.challenge.adapter.outbound.integration.product.ProductAdapter;
import com.challenge.adapter.outbound.repository.QuoteRepository;
import com.challenge.domain.strategy.validade.offer.OfferValidateStrategy;
import com.challenge.domain.strategy.validade.product.ProductValidateStrategy;
import com.challenge.domain.usecase.InsuranceQuoteUseCase;
import com.challenge.domain.usecase.OfferUseCase;
import com.challenge.domain.usecase.ProductUseCase;

@Configuration
public class BeanConfiguration {
	
	@Bean
	OfferUseCase offerUseCase(OfferAdapter offerAdapter, List<OfferValidateStrategy> listOfferValidateStrategies) {
        return new OfferUseCase(offerAdapter,listOfferValidateStrategies);
    }
	
	
	@Bean
	ProductUseCase productUseCase(ProductAdapter productAdapter, List<ProductValidateStrategy> listProductValidates) {
        return new ProductUseCase(productAdapter,listProductValidates);
    }
	
	
	@Bean
	InsuranceQuoteUseCase insuranceQuoteUseCase(ProductAdapter productAdapter, OfferAdapter offerAdapter, List<ProductValidateStrategy> listProductValidates
			,List<OfferValidateStrategy> listOfferValidateStrategies, QuoteRepository quoteRepository, QuoteProducer quoteProducer) {
        return new InsuranceQuoteUseCase(new OfferUseCase(offerAdapter,listOfferValidateStrategies), new ProductUseCase(productAdapter,listProductValidates), quoteRepository, quoteProducer);
    }

}
