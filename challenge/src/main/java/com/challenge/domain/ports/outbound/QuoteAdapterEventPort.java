package com.challenge.domain.ports.outbound;

import com.challenge.adapter.outbound.entities.Quote;

public interface QuoteAdapterEventPort {
	
	void sendQuoteEvent(Quote quoteSaved);

}
