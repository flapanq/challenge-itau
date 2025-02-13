package com.challenge.adapter.outbound.integration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuoteProducer {

	public static final String TOPIC = "quoteTopic";

	@Autowired
	private KafkaTemplate<String, QuoteEvent> kafkaTemplate;

	public void sendQuoteEvent(QuoteEvent quoteEvent) {
		String key = quoteEvent.getId().toString();
		kafkaTemplate.send(TOPIC, key.toString(), quoteEvent);
	}

	

}
