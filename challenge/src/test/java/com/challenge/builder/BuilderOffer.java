package com.challenge.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.challenge.domain.domains.MonthlyPremiumAmountDTO;
import com.challenge.domain.domains.OfferDTO;

public class BuilderOffer {
	
    public static OfferDTO buildAssistanceNotValid() {
		
		LocalDateTime  aLDT = LocalDateTime.parse("2015-08-04T10:11:30"); 

		OfferDTO offer = new OfferDTO(
				UUID.fromString("adc56d77-348c-4bf0-908f-22d402ee715c"),
				UUID.fromString("1b2da7cc-b367-4196-8a78-9cfeec21f587"),
				"Seguro de Vida Familiar",aLDT, true, createCoverages(), createAssistancesNotValid(), createMonthlyPremiumAmount());
		return offer;

	}

	public static OfferDTO build() {
		
		LocalDateTime  aLDT = LocalDateTime.parse("2015-08-04T10:11:30"); 

		OfferDTO offer = new OfferDTO(
				UUID.fromString("adc56d77-348c-4bf0-908f-22d402ee715c"),
				UUID.fromString("1b2da7cc-b367-4196-8a78-9cfeec21f587"),
				"Seguro de Vida Familiar",aLDT, true, createCoverages(), createAssistances(), createMonthlyPremiumAmount());
		return offer;

	}
	
	private static MonthlyPremiumAmountDTO createMonthlyPremiumAmount() {
		return  new MonthlyPremiumAmountDTO(new BigDecimal(100.74), new BigDecimal(50.00), new BigDecimal(60.25));
		
	}
	
	private static Map<String, BigDecimal>  createCoverages() {
		Map<String, BigDecimal> coverages = new HashMap<>();
		coverages.put("Incêndio", new BigDecimal(500000.00));
		coverages.put("Desastres naturais", new BigDecimal(600000.00));
		coverages.put("Roubo", new BigDecimal(100000.00));
		coverages.put("Responsabiliadade civil", new BigDecimal(80000.00));
		return coverages;
	}
	
	private static  List<String> createAssistances(){
		List<String> assistences = new ArrayList();
		assistences.add("Encanador");
		assistences.add("Eletricista");
		assistences.add("Chaveiro 24h");
		assistences.add("Assistência Funerária");
		return assistences;
	}
	
	
	private static  List<String> createAssistancesNotValid(){
		List<String> assistences = new ArrayList();
		assistences.add("Encanador");
		assistences.add("Eletricista");
		assistences.add("Chaveiro 24h");
		return assistences;
	}


}
