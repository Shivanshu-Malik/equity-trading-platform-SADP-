package com.sapient.sterlingCourier.entity;

import java.sql.Date;

public class Customer {

	int customerId;
	String userId;
	String customerName;
	Date dateOfRegistration;
	String address;
	String city;
	String state;
	String pin;
	String telephoneNo;
	String emailId;
	char defaulter;

	public Customer(int customerId, String userId, String customerName, Date dateOfRegistration, String address,
			String city, String pin, String telephoneNo, String emailId, char defaulter) {
		this.customerId = customerId;
		this.userId = userId;
		this.customerName = customerName;
		this.dateOfRegistration = dateOfRegistration;
		this.address = address;
		this.city = city;
		this.pin = pin;
		this.telephoneNo = telephoneNo;
		this.emailId = emailId;
		this.defaulter = defaulter;
	}

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	// only for current usage
	public char getDefaulter() {
		return defaulter;
	}

	public void setDefaulter(char defaulter) {
		this.defaulter = defaulter;
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userId=" + userId + ", customerName=" + customerName
				+ ", dateOfRegistration=" + dateOfRegistration + ", address=" + address + ", city=" + city + ", pin="
				+ pin + ", telephoneNo=" + telephoneNo + ", emailId=" + emailId + ", defaulter=" + defaulter + "]";
	}	

}
