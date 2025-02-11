package com.challenge.domain.usecase;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.adapter.outbound.entities.Assistance;
import com.challenge.adapter.outbound.entities.Coverage;
import com.challenge.adapter.outbound.entities.Customer;
import com.challenge.adapter.outbound.entities.Quote;
import com.challenge.adapter.outbound.integration.kafka.QuoteEvent;
import com.challenge.adapter.outbound.integration.kafka.QuoteProducer;
import com.challenge.adapter.outbound.repository.QuoteRepository;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.domain.ports.inbound.InsuranceQuoteUseCasePort;

public class InsuranceQuoteUseCase implements InsuranceQuoteUseCasePort{
	
	private final OfferUseCase offerUseCase;
	
	private final ProductUseCase productUseCase;
	
	private QuoteRepository quoteRepository;
	
	private QuoteProducer quoteProducer;

	public InsuranceQuoteUseCase(OfferUseCase offerUseCase, ProductUseCase productUseCase, QuoteRepository quoteRepository
			, QuoteProducer quoteProducer) {
		super();
		this.offerUseCase = offerUseCase;
		this.productUseCase = productUseCase;
		this.quoteRepository = quoteRepository;
		this.quoteProducer = quoteProducer;
	}


	@Override
	public Optional<Boolean> execute(QuoteDTO quoteDTO) {
		
		productUseCase.validateProduct(quoteDTO);
		
		offerUseCase.validateOffer(quoteDTO);
		
		Quote quoteEntiy = convertQuoteDTOToEntity(quoteDTO);
		
		Quote quoteSaved =  saveQuote(quoteEntiy);
		
        sendQuoteEvent(quoteSaved);
		
		return Optional.empty();
	}
	
	private Quote saveQuote(Quote quoteEntiy) {
		return quoteRepository.save(quoteEntiy);
	}
	
	private void sendQuoteEvent(Quote quoteSaved) {
		
		QuoteEvent quoteEvent = new QuoteEvent();
		quoteEvent.setId(quoteSaved.getId());
		quoteEvent.setMessage("Solicitação de Cotação Recebida");
		quoteProducer.sendQuoteEvent(quoteEvent);
		
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
