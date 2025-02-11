package com.challenge.adapter.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.adapter.inbound.mapper.QuoteMapper;
import com.challenge.adapter.inbound.request.QuoteRequestParam;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.domain.ports.inbound.InsuranceQuoteUseCasePort;

@RestController
@RequestMapping("/v1/insurance/quote")
public class InsuranceQuoteController {

	
	private QuoteMapper quoteMapper;
	
	private InsuranceQuoteUseCasePort insuranceQuoteUseCasePort;
	
	
	public InsuranceQuoteController(QuoteMapper quoteMapper, InsuranceQuoteUseCasePort insuranceQuoteUseCasePort) {
		super();
		this.quoteMapper = quoteMapper;
		this.insuranceQuoteUseCasePort = insuranceQuoteUseCasePort;
	}

	@PostMapping
	public ResponseEntity<String> insuranceQuoteRequest(@RequestBody QuoteRequestParam quoteRequestParam) {
		
		
		QuoteDTO quote = quoteMapper.sourceToDestination(quoteRequestParam);

		insuranceQuoteUseCasePort.execute(quote);


		return ResponseEntity.ok("Sua solicitacão foi validada e recebida com sucesso");
	}

}
