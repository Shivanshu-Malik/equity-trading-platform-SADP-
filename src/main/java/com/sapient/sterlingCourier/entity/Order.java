package com.sapient.sterlingCourier.entity;

import java.sql.Date;

public class Order {

	int orderId;
	int customerId;
	int employeeId;
	Date orderDate;
	String recipientName;
	String recipientAddress;
	char recipientCity;
	float courierWeight;
	char courierStatus;
	String description;

	public Order(int orderId, int customerId, int employeeId,Date orderDate, String recipientName, String recipientAddress,
			char recipientCity, float courierWeight, char courierStatus, String description) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.orderDate = orderDate;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.recipientCity = recipientCity;
		this.courierWeight = courierWeight;
		this.courierStatus = courierStatus;
		this.description = description;
	}

	public Order() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public char getRecipientCity() {
		return recipientCity;
	}

	public void setRecipientCity(char recipientCity) {
		this.recipientCity = recipientCity;
	}

	public float getCourierWeight() {
		return courierWeight;
	}

	public void setCourierWeight(float courierWeight) {
		this.courierWeight = courierWeight;
	}

	public char getCourierStatus() {
		return courierStatus;
	}

	public void setCourierStatus(char courierStatus) {
		this.courierStatus = courierStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", employeeId=" + employeeId
				+ ", orderDate=" + orderDate + ", recipientName=" + recipientName + ", recipientAddress="
				+ recipientAddress + ", recipientCity=" + recipientCity + ", courierWeight=" + courierWeight
				+ ", courierStatus=" + courierStatus + ", description=" + description + "]";
	}

	

}
