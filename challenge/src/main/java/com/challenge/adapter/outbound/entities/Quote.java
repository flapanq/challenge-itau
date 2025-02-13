package com.challenge.adapter.outbound.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.challenge.domain.enums.CategoryEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quote {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private	UUID productId;
	private UUID offerId;
	private CategoryEnum category;
	private BigDecimal totalMonthlyPremiumAmount;
	private BigDecimal totalCoverageAmount;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Coverage> coverages;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Assistance> assistances;
	@ManyToOne(cascade = CascadeType.ALL)
    private	Customer customer;
	private Long insurancePolicyId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public UUID getOfferId() {
		return offerId;
	}
	public void setOfferId(UUID offerId) {
		this.offerId = offerId;
	}
	public CategoryEnum getCategory() {
		return category;
	}
	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
	public BigDecimal getTotalMonthlyPremiumAmount() {
		return totalMonthlyPremiumAmount;
	}
	public void setTotalMonthlyPremiumAmount(BigDecimal totalMonthlyPremiumAmount) {
		this.totalMonthlyPremiumAmount = totalMonthlyPremiumAmount;
	}
	public BigDecimal getTotalCoverageAmount() {
		return totalCoverageAmount;
	}
	public void setTotalCoverageAmount(BigDecimal totalCoverageAmount) {
		this.totalCoverageAmount = totalCoverageAmount;
	}
	public List<Coverage> getCoverages() {
		return coverages;
	}
	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}
	public List<Assistance> getAssistances() {
		return assistances;
	}
	public void setAssistances(List<Assistance> assistances) {
		this.assistances = assistances;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getInsurancePolicyId() {
		return insurancePolicyId;
	}
	public void setInsurancePolicyId(Long insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}
	
	
	
	

}