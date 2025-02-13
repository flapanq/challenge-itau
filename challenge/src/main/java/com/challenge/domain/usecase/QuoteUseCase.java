package com.challenge.domain.usecase;

import com.challenge.adapter.outbound.entities.Quote;
import com.challenge.domain.ports.inbound.QuoteUseCasePort;
import com.challenge.domain.ports.outbound.QuoteApapterPort;

public class QuoteUseCase implements QuoteUseCasePort {
	
	private QuoteApapterPort quoteApapterPort;

	public QuoteUseCase(QuoteApapterPort quoteApapterPort) {
		super();
		this.quoteApapterPort = quoteApapterPort;
	}

	@Override
	public void updateInsurancePolicyId(Long quoteId, Long insurancePolicyId) {
		
       Quote quote = quoteApapterPort.findById(quoteId);
       
       quote.setInsurancePolicyId(insurancePolicyId);
       
       quoteApapterPort.saveQuote(quote);
		
	}

	
}
