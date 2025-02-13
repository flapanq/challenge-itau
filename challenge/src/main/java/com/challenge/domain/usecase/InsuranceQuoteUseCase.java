package com.challenge.domain.usecase;

import java.util.ArrayList;
import java.util.Optional;

import com.challenge.adapter.outbound.entities.Assistance;
import com.challenge.adapter.outbound.entities.Coverage;
import com.challenge.adapter.outbound.entities.Customer;
import com.challenge.adapter.outbound.entities.Quote;
import com.challenge.adapter.outbound.integration.kafka.QuoteProducer;
import com.challenge.adapter.outbound.integration.quote.QuoteEnventAdapter;
import com.challenge.adapter.outbound.repository.QuoteRepository;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.domain.ports.inbound.InsuranceQuoteUseCasePort;
import com.challenge.domain.ports.outbound.QuoteApapterPort;

public class InsuranceQuoteUseCase implements InsuranceQuoteUseCasePort{
	
	private final OfferUseCase offerUseCase;
	
	private final ProductUseCase productUseCase;
	
	private QuoteApapterPort quoteApapterPort;
	
	private QuoteEnventAdapter quoteEnventAdapter;
	

	public InsuranceQuoteUseCase(OfferUseCase offerUseCase, ProductUseCase productUseCase, QuoteRepository quoteRepository
			, QuoteProducer quoteProducer, QuoteApapterPort quoteApapterPort, QuoteEnventAdapter quoteEnventAdapter) {
		super();
		this.offerUseCase = offerUseCase;
		this.productUseCase = productUseCase;
		this.quoteApapterPort = quoteApapterPort;
		this.quoteEnventAdapter = quoteEnventAdapter;
	}


	@Override
	public Optional<Boolean> execute(QuoteDTO quoteDTO) {
		
		productUseCase.validateProduct(quoteDTO);
		
		offerUseCase.validateOffer(quoteDTO);
		
		Quote quoteEntiy = convertQuoteDTOToEntity(quoteDTO);
		
		Quote quoteSaved =  quoteApapterPort.saveQuote(quoteEntiy);
		
		quoteEnventAdapter.sendQuoteEvent(quoteSaved);
		
		return Optional.empty();
	}
	
	
	private Quote convertQuoteDTOToEntity(QuoteDTO quoteDTO) {
		
		Quote quote = new Quote();
		quote.setProductId(quoteDTO.productId());
		quote.setOfferId(quoteDTO.offerId());
		quote.setCategory(quoteDTO.category());
		quote.setTotalMonthlyPremiumAmount(quoteDTO.totalMonthlyPremiumAmount());
		quote.setTotalCoverageAmount(quoteDTO.totalCoverageAmount());
		quote.setCoverages(new ArrayList<>());
		quote.setAssistances(new ArrayList<>() );
		
		quoteDTO.coverages().forEach((key, tab) -> {
			Coverage coverage = new  Coverage();
			coverage.setName(key);
			coverage.setValue(tab);
			quote.getCoverages().add(coverage);
		});
		
		quoteDTO.assistances().forEach(item -> {
			Assistance assistance = new Assistance();
			assistance.setName(item);
			quote.getAssistances().add(assistance);
		});
		
	    Customer customer = new Customer();
        customer.setDocumentNumber(quoteDTO.customer().documentNumber());	
        customer.setName(quoteDTO.customer().name());
        customer.setType(quoteDTO.customer().type());
        customer.setGender(quoteDTO.customer().gender());
        customer.setDateOfBirth(quoteDTO.customer().dateOfBirth());
        customer.setEmail(quoteDTO.customer().email());
        customer.setPhoneNumber(quoteDTO.customer().phoneNumber());
        
        quote.setCustomer(customer);
		
		return quote;
		
		
		
	}

	

}