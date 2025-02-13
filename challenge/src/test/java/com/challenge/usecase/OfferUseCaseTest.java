package com.challenge.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.builder.BuilderOffer;
import com.challenge.builder.BuilderQuote;
import com.challenge.domain.ports.outbound.OfferAdapterPort;
import com.challenge.domain.strategy.validade.offer.OfferActiveStrategy;
import com.challenge.domain.strategy.validade.offer.OfferAssistanceStrategy;
import com.challenge.domain.strategy.validade.offer.OfferCoverageStrategy;
import com.challenge.domain.strategy.validade.offer.OfferCoverageTotalStrategy;
import com.challenge.domain.strategy.validade.offer.OfferMinMaxStrategy;
import com.challenge.domain.strategy.validade.offer.OfferValidateStrategy;
import com.challenge.domain.usecase.OfferUseCase;

@SpringBootTest
public class OfferUseCaseTest {
	
	@Mock
	private OfferAdapterPort offerAdapterPort;

	private OfferUseCase offerUseCase;
	
	@BeforeEach
	void setup() {
		List<OfferValidateStrategy> listOfferValidates = new ArrayList<>();
		listOfferValidates.add(new OfferAssistanceStrategy());
		listOfferValidates.add(new OfferActiveStrategy());
		listOfferValidates.add(new OfferCoverageStrategy());
		listOfferValidates.add(new OfferMinMaxStrategy());
		listOfferValidates.add(new OfferCoverageTotalStrategy());
		offerUseCase = new OfferUseCase(offerAdapterPort,listOfferValidates);
	}
	
	
	 @Test()
	public void testValidateOfferAssistance() {
		
		try {
			when(offerAdapterPort.findOfferByProduct(any())).thenReturn(BuilderOffer.buildAssistanceNotValid());
			offerUseCase.validateOffer(BuilderQuote.buildDTO());
		}catch (Exception e) {
			assertEquals(e.getMessage(),"Assitencia não válida.");
		}
		
	}


}
