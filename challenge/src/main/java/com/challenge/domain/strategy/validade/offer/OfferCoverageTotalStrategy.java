package com.challenge.domain.strategy.validade.offer;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.domain.domains.OfferDTO;
import com.challenge.domain.domains.QuoteDTO;
import com.challenge.infra.exceptions.offer.OfferTotalCoverageException;

@Component("Offer Coverage Total")
public class OfferCoverageTotalStrategy implements OfferValidateStrategy {

	@Override
	public void validate(OfferDTO offer, QuoteDTO quote) {

		List<BigDecimal> coverages = new LinkedList<>();

		quote.coverages().forEach((key, tab) -> {
			coverages.add(tab);
		});
		
		BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal amt : coverages) {
            sum = sum.add(amt);
        }


	    if(quote.totalCoverageAmount().compareTo(sum) != 0) {
	    	throw new OfferTotalCoverageException();
	    }

	}

}
