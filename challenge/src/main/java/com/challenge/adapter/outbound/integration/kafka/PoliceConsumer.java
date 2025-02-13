package com.challenge.adapter.outbound.integration.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.challenge.domain.ports.inbound.QuoteUseCasePort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PoliceConsumer {
	
	private QuoteUseCasePort quoteUseCasePort;
	
	public PoliceConsumer(QuoteUseCasePort quoteUseCasePort) {
		super();
		this.quoteUseCasePort = quoteUseCasePort;
	}

	@KafkaListener(topics = "insurancePolicy", groupId = "policyGroup")
    public void flightEventConsumer(PoliceEvent policeEvent) {
		
		quoteUseCasePort.updateInsurancePolicyId(policeEvent.getId(), policeEvent.getInsurancePolicyId());
		
		System.out.println("Message receved " + policeEvent.getId());

        // write your handlers and post-processing logic, based on your use case
    }


}
