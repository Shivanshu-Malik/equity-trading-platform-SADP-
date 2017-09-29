package com.sapient.sterlingCourier.tester;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;//change this

import com.sapient.sterlingCourier.dao.SterlingDAO;
import com.sapient.sterlingCourier.entity.Invoice;

public class InvoiceTester {

	Invoice invoice;
	SterlingDAO sterlingDAO;

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public void readInvoiceInfo(int customerId, int invoiceMonth, int invoiceYear, String description) {

		sterlingDAO = new SterlingDAO();
		invoice = new Invoice();

		invoice.setCustomerId(customerId);
		invoice.setInvoiceMonth(invoiceMonth);
		invoice.setInvoiceYear(invoiceYear);
		invoice.setDescription(description);

		DateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy");// set to today's date i.e date of issue of invoice
		Date todaysDate = Calendar.getInstance().getTime();
		String invoiceDate = simpleDateFormat.format(todaysDate);
		invoice.setInvoiceDate(invoiceDate);
		/*int invoiceId = 0// Random generation of invoiceId
		invoice.setInvoiceId(invoiceId);*/
		/*invoice.setAmount(1000);*/

		sterlingDAO.saveInvoice(invoice);
		displayInvoiceInfo(invoice);

	}

	public void displayInvoiceInfo(Invoice invoice) {

		System.out.println("");
		System.out.println("Invoice Generation");
		System.out.println("-------------------------------------");
		System.out.println("Customer Id                       :" + invoice.getCustomerId());
		System.out.println("Invoice Month                     :" + invoice.getInvoiceMonth());
		System.out.println("Invoice Year                      :" + invoice.getInvoiceYear());
		System.out.println("Description                       :" + invoice.getDescription());

	}

}
