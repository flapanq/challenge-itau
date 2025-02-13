package com.challenge.adapter.outbound.integration.quote;

import org.springframework.stereotype.Component;

import com.challenge.adapter.outbound.entities.Quote;
import com.challenge.adapter.outbound.integration.kafka.QuoteEvent;
import com.challenge.adapter.outbound.integration.kafka.QuoteProducer;
import com.challenge.domain.ports.outbound.QuoteAdapterEventPort;

@Component
public class QuoteEnventAdapter implements QuoteAdapterEventPort {

	private QuoteProducer quoteProducer;

	public QuoteEnventAdapter(QuoteProducer quoteProducer) {
		super();
		this.quoteProducer = quoteProducer;
	}

	public void sendQuoteEvent(Quote quoteSaved) {

		QuoteEvent quoteEvent = new QuoteEvent();
		quoteEvent.setId(quoteSaved.getId());
		quoteEvent.setMessage("Solicitação de Cotação Recebida");
		quoteProducer.sendQuoteEvent(quoteEvent);

	}

}
