package com.mip.app.model;

public class CustomerSubscriptions {
	
private static final long serialVersionUID = -337498956721287889L;
	
	private int offerId;
	private int offerCoverId;
	private int  healthTipsSmsFrequency;
	private String healthTipsSmsLang;
	private String documentValue;
	private int documentTypeId;
	private int paymentConfigurationId;
	private int paymentChannelId;
	private int registeredChannelId;
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getOfferCoverId() {
		return offerCoverId;
	}
	public void setOfferCoverId(int offerCoverId) {
		this.offerCoverId = offerCoverId;
	}
	public int getHealthTipsSmsFrequency() {
		return healthTipsSmsFrequency;
	}
	public void setHealthTipsSmsFrequency(int healthTipsSmsFrequency) {
		this.healthTipsSmsFrequency = healthTipsSmsFrequency;
	}
	public String getHealthTipsSmsLang() {
		return healthTipsSmsLang;
	}
	public void setHealthTipsSmsLang(String healthTipsSmsLang) {
		this.healthTipsSmsLang = healthTipsSmsLang;
	}
	public String getDocumentValue() {
		return documentValue;
	}
	public void setDocumentValue(String documentValue) {
		this.documentValue = documentValue;
	}
	public int getDocumentTypeId() {
		return documentTypeId;
	}
	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	public int getPaymentConfigurationId() {
		return paymentConfigurationId;
	}
	public void setPaymentConfigurationId(int paymentConfigurationId) {
		this.paymentConfigurationId = paymentConfigurationId;
	}
	public int getPaymentChannelId() {
		return paymentChannelId;
	}
	public void setPaymentChannelId(int paymentChannelId) {
		this.paymentChannelId = paymentChannelId;
	}
	public int getRegisteredChannelId() {
		return registeredChannelId;
	}
	public void setRegisteredChannelId(int registeredChannelId) {
		this.registeredChannelId = registeredChannelId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
