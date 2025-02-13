package com.challenge.adapter.outbound.integration.kafka;

public class PoliceEvent {
	
	private Long id;
	private Long insurancePolicyId;
	private String message;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInsurancePolicyId() {
		return insurancePolicyId;
	}
	public void setInsurancePolicyId(Long insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	

}
