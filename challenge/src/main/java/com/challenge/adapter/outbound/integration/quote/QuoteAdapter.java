package com.challenge.adapter.outbound.integration.quote;

import org.springframework.stereotype.Component;

import com.challenge.adapter.outbound.entities.Quote;
import com.challenge.adapter.outbound.repository.QuoteRepository;
import com.challenge.domain.ports.outbound.QuoteApapterPort;

@Component
public class QuoteAdapter implements QuoteApapterPort {
	
	private QuoteRepository quoteRepository;

	public QuoteAdapter(QuoteRepository quoteRepository) {
		super();
		this.quoteRepository = quoteRepository;
	}

	
	public Quote saveQuote(Quote quoteEntiy) {
		return quoteRepository.save(quoteEntiy);
	}
	
	
	public Quote findById(Long id) {
		return quoteRepository.findById(id).get();
	}
	

	
	

}
