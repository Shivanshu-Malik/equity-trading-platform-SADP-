package com.sapient.sterlingCourier.entity;

public class Invoice {

	int invoiceId;
	int customerId;
	String invoiceDate;
	int invoiceMonth;
	int invoiceYear;
	double amount;
	String description;

	public Invoice(int invoiceId, int customerId, String invoiceDate, int invoiceMonth, int invoiceYear, double amount,
			String description) {
		super();
		this.invoiceId = invoiceId;
		this.customerId = customerId;
		this.invoiceDate = invoiceDate;
		this.invoiceMonth = invoiceMonth;
		this.invoiceYear = invoiceYear;
		this.amount = amount;
		this.description = description;
	}

	public Invoice() {
		super();

	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getInvoiceMonth() {
		return invoiceMonth;
	}

	public void setInvoiceMonth(int invoiceMonth) {
		this.invoiceMonth = invoiceMonth;
	}

	public int getInvoiceYear() {
		return invoiceYear;
	}

	public void setInvoiceYear(int invoiceYear) {
		this.invoiceYear = invoiceYear;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", customerId=" + customerId + ", invoiceDate=" + invoiceDate
				+ ", invoiceMonth=" + invoiceMonth + ", invoiceYear=" + invoiceYear + ", amount=" + amount
				+ ", description=" + description + "]";
	}

}
