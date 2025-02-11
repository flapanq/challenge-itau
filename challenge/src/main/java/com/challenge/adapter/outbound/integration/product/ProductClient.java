package com.challenge.adapter.outbound.integration.product;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.challenge.domain.domains.ProductDTO;

@FeignClient(name = "product", url = "http://localhost:1080/api/v1/products" )
public interface ProductClient {
	
	@GetMapping
	ProductDTO findProduct(@RequestParam("id") UUID id);

}
