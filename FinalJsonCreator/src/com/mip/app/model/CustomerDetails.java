package com.mip.app.model;

public class CustomerDetails {
	
private static final long serialVersionUID = 2474997956721287889L;
	
	private String customerName;
	private int customerAge;
	private String customerGender;
	private String customerMsisdn;
	private int createdBy;
	private String createdDate;
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createddate) {
		this.createdDate = createddate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerMsisdn() {
		return customerMsisdn;
	}
	public void setCustomerMsisdn(String customerMsisdn) {
		this.customerMsisdn = customerMsisdn;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
