package com.challenge.domain.domains;

import java.time.LocalDate;

import com.challenge.domain.enums.GenderEnum;
import com.challenge.domain.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerDTO(@JsonProperty("document_number") String documentNumber, String name,  TypeEnum type, GenderEnum gender, @JsonProperty("date_of_birth")  LocalDate dateOfBirth, String email
		, @JsonProperty("phone_number") String phoneNumber) {
	
	

}
