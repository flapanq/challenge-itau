package com.challenge.infra.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challenge.infra.exceptions.offer.OfferAssistanceException;
import com.challenge.infra.exceptions.offer.OfferCoverageException;
import com.challenge.infra.exceptions.offer.OfferMaxMinException;
import com.challenge.infra.exceptions.offer.OfferNotActiveException;
import com.challenge.infra.exceptions.offer.OfferTotalCoverageException;

@RestControllerAdvice
public class WebRestControllerAdvice {

	@ExceptionHandler({ ProductNotFoundException.class, })
	public ResponseEntity<ApiError> notFoundException(RuntimeException ex) {
		ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
				List.of(ex.getMessage()));
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler({ ProductNotActiveException.class, OfferNotActiveException.class, 
		OfferCoverageException.class, OfferAssistanceException.class, OfferMaxMinException.class,
		OfferTotalCoverageException.class})
	public ResponseEntity<ApiError> notActiveException(RuntimeException ex) {
		ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				List.of(ex.getMessage()));
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

}
