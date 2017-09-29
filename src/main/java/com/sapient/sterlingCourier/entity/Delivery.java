package com.sapient.sterlingCourier.entity;

import java.sql.Date;

public class Delivery {

	int orderId;
	Date deliveryDate;
	String remarks;
	/*int employeeID;// added (later an employee class can be created and can be made an instance variable of this class)
	char status;// added
*/
	public Delivery(int orderId, Date deliveryDate, String remarks, int employeeID, char status) {
		super();
		this.orderId = orderId;
		this.deliveryDate = deliveryDate;
		this.remarks = remarks;
		/*this.employeeID = employeeID;
		this.status = status;*/
	}

	public Delivery() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Delivery [orderId=" + orderId + ", deliveryDate=" + deliveryDate + ", remarks=" + remarks + "]";
	}

	/*public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}*/

	/*@Override
	public String toString() {
		return "Delivery [orderId=" + orderId + ", deliveryDate=" + deliveryDate + ", remarks=" + remarks
				+ ", employeeID=" + employeeID + ", status=" + status + "]";
	}*/
	
	

}
