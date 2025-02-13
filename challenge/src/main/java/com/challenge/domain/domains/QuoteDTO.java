package com.challenge.domain.domains;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.challenge.domain.enums.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public record QuoteDTO(@JsonProperty("product_id") UUID productId, @JsonProperty("offer_id") UUID offerId,
		CategoryEnum category, @JsonProperty("total_monthly_premium_amount") BigDecimal totalMonthlyPremiumAmount,
		@JsonProperty("total_coverage_amount") BigDecimal totalCoverageAmount, Map<String, BigDecimal> coverages,
		List<String> assistances, CustomerDTO customer) {
	

}
