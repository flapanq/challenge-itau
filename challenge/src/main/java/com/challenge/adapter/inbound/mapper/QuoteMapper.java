package com.challenge.adapter.inbound.mapper;

import org.mapstruct.Mapper;

import com.challenge.adapter.inbound.request.QuoteRequestParam;
import com.challenge.domain.domains.QuoteDTO;

@Mapper(componentModel = "spring")
public interface QuoteMapper {
	
	QuoteDTO sourceToDestination(QuoteRequestParam source);

}
