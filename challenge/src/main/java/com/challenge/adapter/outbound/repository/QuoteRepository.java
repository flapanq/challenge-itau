package com.challenge.adapter.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.adapter.outbound.entities.Quote;


public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
