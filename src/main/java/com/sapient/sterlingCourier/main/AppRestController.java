package com.sapient.sterlingCourier.main;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sterlingCourier.constants.HTTP_CONSTANTS;
import com.sapient.sterlingCourier.entity.Customer;
import com.sapient.sterlingCourier.entity.Delivery;
import com.sapient.sterlingCourier.entity.Invoice;
import com.sapient.sterlingCourier.entity.Order;
import com.sapient.sterlingCourier.entity.ResponseEntityBean;
import com.sapient.sterlingCourier.exception.InvalidEmployeeException;
import com.sapient.sterlingCourier.exception.OrderNotAssignedException;
import com.sapient.sterlingCourier.tester.CustomerTester;
import com.sapient.sterlingCourier.tester.DeliveryTester;
import com.sapient.sterlingCourier.tester.DistributionTester;
import com.sapient.sterlingCourier.tester.InvoiceTester;
import com.sapient.sterlingCourier.tester.OrderTester;



//@Path("/rest")
@RestController
public class AppRestController {
	CustomerTester customerTester = new CustomerTester();
	OrderTester orderTester = new OrderTester();
	DistributionTester distributionTester = new DistributionTester();
	DeliveryTester deliveryTester = new DeliveryTester();
	InvoiceTester invoiceTester = new InvoiceTester();
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	/*@POST
	@Path("/registerCustomer")*/
	//@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			value = "/customer/registerCustomer",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEntityBean> registerCustomer(@RequestBody Customer customer){
		//Customer customer;
		String data="";
		System.out.println(data);
		try {
			//customer = objectMapper.readValue(data, Customer.class);
			Integer customerId = customerTester.readCustomerInfo(customer.getCustomerName(), 
					customer.getAddress(), customer.getDateOfRegistration(), 
					customer.getCity(), customer.getPin(), customer.getTelephoneNo(), customer.getEmailId());
			System.out.println(customerId);
			String output = objectMapper.writeValueAsString(customerId);
			return new ResponseEntity<ResponseEntityBean>(new ResponseEntityBean(customerId.toString()),HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<ResponseEntityBean>(new ResponseEntityBean("Something went wrong!!!"),HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseEntityBean>(new ResponseEntityBean("Something went wrong!!!"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@RequestMapping(
			value = "/order/getOrders",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
					)
	public ResponseEntity<List<Order>> getAllOrders(@RequestParam	String orderId){
		
		List<Order> orderCollection = new ArrayList();
		try {
			orderCollection.addAll(orderTester.getOrderInfo(Integer.parseInt(orderId)));
			System.out.println("Controller");
			System.out.println(orderCollection);
			return new ResponseEntity<List<Order>>(orderCollection,HttpStatus.OK);
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Order>>(orderCollection,HttpStatus.BAD_REQUEST);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Order>>(orderCollection,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	/*@GET
	@Path("/createNewOrder")
	public void createNewOrder(){
		Order order;
		String data = "ABCD";
		System.out.println(data);
		try {
			order = objectMapper.readValue(data, Order.class);
			orderTester.readOrderInfo(order.getRecipientName(), order.getRecipientAddress(), order.getRecipientCity(), order.getOrderDate(),
					order.getCourierWeight(), order.getDescription(), order.getCustomerId());
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@GET
	@Path("/checkOrderStatus")
	public void checkOrderStatus(@PathParam("orderId") String orderId){
		Order order;
		Integer orderID = Integer.parseInt(orderId);
		
		
			orderTester.checkOrderStatus(orderID);
			
		
		
	}*/
	
	//@GET
	//@Path("/getOrdersNotClosed")
	@RequestMapping(
			value = "/order/getOrdersNotClosed",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
					)
	public ResponseEntity<Collection<Order>> getOrdersNotClosed(@RequestParam String employeeId){
		Order order;
		Integer empID = Integer.parseInt(employeeId);		
		Collection<Order> orderCollection = null;
		try {
			orderCollection = orderTester.getOrdersNotClosed(empID);
			return new ResponseEntity<Collection<Order>>(orderCollection,HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Collection<Order>>(orderCollection,HttpStatus.BAD_REQUEST);
		} catch (InvalidEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Collection<Order>>(orderCollection,HttpStatus.BAD_REQUEST);
		} catch (OrderNotAssignedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Collection<Order>>(orderCollection,HttpStatus.BAD_REQUEST);
		}
			
			
		
	}
	/*
	@GET
	@Path("/getOrderInfo")
	public void getOrderInfo(){
		Order order;
		Integer orderID = Integer.parseInt("12");
		
		
			orderTester.getOrderInfo(orderID);
			
		
		
	}
	
	@GET
	@Path("/readDistributionListInfo")
	public void readDistributionListInfo(){
		Order order;
		java.sql.Date dateOfDistribution = new java.sql.Date(new Date("12-12-2001").getTime());
		
		
			distributionTester.readDistributionListInfo(dateOfDistribution);
			
		
		
	}
	
	@GET
	@Path("/readDeliveryInfo")
	public void readDeliveryInfo(){
		String data = "ABCD";
		System.out.println(data);
		Delivery delivery;
		char status = 'P';
		try {
			delivery = objectMapper.readValue(data, Delivery.class);
			deliveryTester.readDeliveryInfo(delivery.getOrderId(), delivery.getDeliveryDate(), delivery.getRemarks(), status);
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	@GET
	@Path("/readInvoiceInfo")
	public void readInvoiceInfo(){
		String data = "ABCD";
		System.out.println(data);
		Invoice invoice;
		try {
			invoice = objectMapper.readValue(data, Invoice.class);
			invoiceTester.readInvoiceInfo(invoice.getCustomerId(), invoice.getInvoiceMonth(), invoice.getInvoiceYear(), invoice.getDescription());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	@GET
	@Path("/getListOfOpenOrders")
	public void getListOfOpenOrders(){
		String data = "ABCD";
		System.out.println(data);
		Invoice invoice;
		try {
			invoice = objectMapper.readValue(data, Invoice.class);
			orderTester.getListOfOpenOrders();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}*/
	//@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/customer/getAllCustomers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomer(){
		/*Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setTelephoneNo("123");
		
		Customer customer2 = new Customer();
		customer2.setCustomerId(2);
		customer2.setTelephoneNo("123");
		
		Collection<Customer> customerCollection = new ArrayList<Customer>();
		customerCollection.add(customer1);
		customerCollection.add(customer2);*/
		List<Customer> customerList = null;
		try {
			customerList = customerTester.getAllCustomers();
			System.out.println("Controller");
			System.out.println(customerList);
			return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Customer>>(customerList,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
}
