package com.challenge.domain.ports.outbound;

import com.challenge.adapter.outbound.entities.Quote;

public interface QuoteApapterPort {

	Quote saveQuote(Quote quoteEntiy);
	
	Quote findById(Long id);

}
