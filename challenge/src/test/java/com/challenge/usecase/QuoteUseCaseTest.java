package com.challenge.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.builder.BuilderQuote;
import com.challenge.domain.ports.outbound.QuoteApapterPort;
import com.challenge.domain.usecase.QuoteUseCase;

@SpringBootTest
public class QuoteUseCaseTest {

	@Mock
	private QuoteApapterPort quoteApapterPort;

	private QuoteUseCase quoteUseCase;

	@BeforeEach
	void setup() {
		quoteUseCase = new QuoteUseCase(quoteApapterPort);
	}

	@Test
    public void testIUpdateInsurancePolicyId() {
		
		when(quoteApapterPort.findById(any())).thenReturn(BuilderQuote.build());
		when(quoteApapterPort.saveQuote(any())).thenReturn(BuilderQuote.build());
		
		quoteUseCase.updateInsurancePolicyId(1L, 1L);
		
		 verify(quoteApapterPort, times(1)).findById(any());
		 verify(quoteApapterPort, times(1)).saveQuote(any());
    }

}
