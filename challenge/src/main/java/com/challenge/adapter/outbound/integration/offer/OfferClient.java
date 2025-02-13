package com.challenge.adapter.outbound.integration.offer;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.challenge.domain.domains.OfferDTO;

@FeignClient(name = "offer", url = "http://localhost:1080/api/v1/offers" )
public interface OfferClient {
	
	@GetMapping
	OfferDTO findOfferByProduct(@RequestParam("productId") UUID productId);

}
