package com.challenge.adapter.inbound;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.adapter.inbound.mapper.QuoteMapper;
import com.challenge.adapter.inbound.request.QuoteRequestParam;
import com.challenge.adapter.outbound.messages.ApiSucess;
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
	public ResponseEntity<ApiSucess> insuranceQuoteRequest(@RequestBody QuoteRequestParam quoteRequestParam) {
		
		
		QuoteDTO quote = quoteMapper.sourceToDestination(quoteRequestParam);

		insuranceQuoteUseCasePort.execute(quote);

		List<String> msg = new ArrayList<>();
		msg.add("Sua solicitacão foi validada e recebida com sucesso");
		ApiSucess apiSucess = new ApiSucess("200", msg);

		return ResponseEntity.ok(apiSucess);
	}

}