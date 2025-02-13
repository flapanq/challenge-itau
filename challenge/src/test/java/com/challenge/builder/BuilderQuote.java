package com.challenge.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.challenge.adapter.outbound.entities.Quote;
import com.challenge.domain.domains.QuoteDTO;

public class BuilderQuote {

	public static Quote build() {

		Quote quote = new Quote();
		quote.setId(10L);

		return quote;
	}

	public static QuoteDTO buildDTO() {

		QuoteDTO quote = new QuoteDTO(null, null, null, null, null, null, createAssistances(), null);

//		@JsonProperty("product_id") UUID productId, @JsonProperty("offer_id") UUID offerId,
//		CategoryEnum category, @JsonProperty("total_monthly_premium_amount") BigDecimal totalMonthlyPremiumAmount,
//		@JsonProperty("total_coverage_amount") BigDecimal totalCoverageAmount, Map<String, BigDecimal> coverages,
//		List<String> assistances, CustomerDTO customer

		return quote;
	}

	private static List<String> createAssistances() {
		List<String> assistences = new ArrayList();
		assistences.add("Encanador");
		assistences.add("Eletricista");
		assistences.add("Chaveiro 24h");
		assistences.add("Assistência Funerária");
		return assistences;
	}

}
