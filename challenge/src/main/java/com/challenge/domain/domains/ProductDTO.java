package com.challenge.domain.domains;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDTO(String id, String name, @JsonProperty("created_at") LocalDateTime createdAt, Boolean active, List<String> offers) {

}
