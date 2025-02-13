package com.challenge.domain.domains;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OfferDTO(UUID id, @JsonProperty("product_id") UUID productId, String name,
		@JsonProperty("created_at") LocalDateTime createdAt, Boolean active, Map<String, BigDecimal> coverages,
		List<String> assistances, @JsonProperty("monthly_premium_amount") MonthlyPremiumAmountDTO monthlyPremiumAmount) {

}
