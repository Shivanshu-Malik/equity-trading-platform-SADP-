package com.sapient.sterlingCourier.tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sapient.sterlingCourier.dao.SterlingDAO;
import com.sapient.sterlingCourier.entity.Customer;


public class CustomerTester {

	Customer customer;
	SterlingDAO sterlingDAO;
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultset=null;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerTester [customer=" + customer + "]";
	}

	public int  readCustomerInfo(String customerName, String address, Date dateOfRegistration, String city, String pin, String telephoneNo,
			String emailId) throws SQLException{

		sterlingDAO = new SterlingDAO();
		customer = new Customer();
		
		customer.setCustomerName(customerName);

		customer.setDateOfRegistration(dateOfRegistration);

		customer.setAddress(address);

		customer.setCity(city);

		customer.setPin(pin);

		customer.setTelephoneNo(telephoneNo);

		customer.setEmailId(emailId);

	
		int customerId=0;
		String userId=null;
		customer.setCustomerId(customerId);
		customer.setUserId(userId);
		customer.setDefaulter('N'); 
		sterlingDAO.saveCustomer(customer);
		displayCustomerInfo(customer);
		return customerId;

	}

	public void displayCustomerInfo(Customer customer) {
		System.out.println("");
		System.out.println("Customer Registration");
		System.out.println("-------------------------------------");
		System.out.println("Customer Name                     :" + customer.getCustomerName());
		System.out.println("Date Of Registration              :" + customer.getDateOfRegistration());
		System.out.println("Address                           :" + customer.getAddress());
		System.out.println("City                              :" + customer.getCity());
		System.out.println("Pin                               :" + customer.getPin());
		System.out.println("Telephone Number                  :" + customer.getTelephoneNo());
		System.out.println("E-mail Id                	  :" + customer.getEmailId());

	}

	public Customer getCustomerData(int customerid) throws SQLException{
		sterlingDAO = new SterlingDAO();
		return sterlingDAO.retrieveCustomerInfo(customerid);		
	}
	
	public List getAllCustomers() throws SQLException{
		sterlingDAO = new SterlingDAO();
		return sterlingDAO.retrieveAllCustomerInfo();		
		
	}

}
