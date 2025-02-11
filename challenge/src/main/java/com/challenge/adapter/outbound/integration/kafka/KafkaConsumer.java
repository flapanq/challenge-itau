package com.challenge.adapter.outbound.integration.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "insurancePolicy", groupId = "policyGroup")
    public void flightEventConsumer(MyEvent message) {
		
		System.out.println("Message receved " + message.getKey());

        // write your handlers and post-processing logic, based on your use case
    }


}
