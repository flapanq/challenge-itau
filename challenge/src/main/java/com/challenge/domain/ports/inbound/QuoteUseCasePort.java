package com.challenge.domain.ports.inbound;

public interface QuoteUseCasePort {
	
	void updateInsurancePolicyId(Long quoteId, Long insurancePolicyId);

}
