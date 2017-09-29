package com.sapient.sterlingCourier.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.sapient.sterlingCourier.entity.Customer;
import com.sapient.sterlingCourier.entity.Delivery;
import com.sapient.sterlingCourier.entity.Invoice;
import com.sapient.sterlingCourier.entity.Order;
import com.sapient.sterlingCourier.exception.InvalidCourierWeightException;
import com.sapient.sterlingCourier.exception.InvalidCustomerException;
import com.sapient.sterlingCourier.exception.InvalidDateException;
import com.sapient.sterlingCourier.exception.InvalidEmployeeException;
import com.sapient.sterlingCourier.exception.InvalidOrderException;
import com.sapient.sterlingCourier.exception.InvoiceGeneratedException;
import com.sapient.sterlingCourier.exception.NoNewOrderException;
import com.sapient.sterlingCourier.exception.OrderNotAssignedException;
import com.sapient.sterlingCourier.service.DBConnect;

/**
 * @author aja122
 *
 */
public class SterlingDAO {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultset = null;
	CallableStatement callableStatement = null;

	public void saveOrder(Order order) throws SQLException {

		int orderId = order.getOrderId();
		int customerId = order.getCustomerId();
		// int employeeId=order.getEmployeeId();
		java.sql.Date orderDate = order.getOrderDate();
		String recipientName = order.getRecipientName();
		String recipientAddress = order.getRecipientAddress();
		char recipientCity = order.getRecipientCity();
		float courierWeight = order.getCourierWeight();
		char courierStatus = order.getCourierStatus();
		String description = order.getDescription();
		int returnValue;

		try {
			connection = DBConnect.getConnection();
			callableStatement = connection
					.prepareCall("{?=call saveOrder(?,?,?,?,?,?,?,?,?)}");
			callableStatement.setInt(2, orderId);
			callableStatement.setInt(3, customerId);
			// callableStatement.setInt(4,employeeId);
			callableStatement.setDate(4, orderDate);
			callableStatement.setString(5, recipientName);
			callableStatement.setString(6, recipientAddress);
			callableStatement.setString(7, String.valueOf(recipientCity));
			callableStatement.setFloat(8, courierWeight);
			callableStatement.setString(9, String.valueOf(courierStatus));
			callableStatement.setString(10, description);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.execute();
			// System.out.println(callableStatement.getInt(1));

			returnValue = callableStatement.getInt(1);
			if (returnValue == 1) {
				throw new InvalidCustomerException(
						"CustomerId is not valid hence order not saved");
			} else if (returnValue == 0) {
				throw new InvalidCourierWeightException(
						"Courier Weight should be in the range of 1-5 Kg hence order not saved");
			} else if (returnValue == 3) {
				throw new SQLException(
						"Some Exception Occured hence order not saved");
			} else {
				System.out.println("Saved order details");
			}
		} catch (InvalidCustomerException e) {
			e.printStackTrace();
		}

		catch (InvalidCourierWeightException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void retrieveOrderStatus(int orderID) {
		String returnValue;
		try {
			connection = DBConnect.getConnection();
			callableStatement = connection
					.prepareCall("{?=call checkOrderStatus(?)}");
			callableStatement.setInt(2, orderID);
			callableStatement.registerOutParameter(1, Types.CHAR);
			callableStatement.execute();

			returnValue = callableStatement.getNString(1);

			if (returnValue.equalsIgnoreCase("N")) {
				throw new InvalidOrderException(
						"Order ID is invalid i.e. order does not exist ");
			} else if (returnValue.equalsIgnoreCase("F")) {
				throw new SQLException("Some exception occured");
			} else {
				System.out.println(callableStatement.getNString(1));
			}

		} catch (InvalidOrderException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {

			System.out.println("exception caught in retrieveOrderStatus");
			e.printStackTrace();
		}

	}

	public ResultSet retrieveOrder(int orderId1) {
		// System.out.println("reached retrieveOrder");

		int customerId = 0;
		int employeeId = 0;
		// Date orderDate;
		String recipientName = null;
		String recipientAddress = null;
		String recipientCity = null;
		float courierWeight = 0;
		String courierStatus = null;
		String description = null;

		try {

			connection = DBConnect.getConnection();
			preparedStatement = connection
					.prepareStatement("select * from sterling_order where orderid=?");
			preparedStatement.setInt(1, orderId1);
			resultset = preparedStatement.executeQuery();
			if (!resultset.isBeforeFirst()) {
				throw new InvalidOrderException("Invalid Order ID ");
			} else {
				// System.out.println("result set " + resultset);

				/*while (resultset.next()) {
					customerId = resultset.getInt("customerId");
					employeeId = resultset.getInt("employeeId");
					recipientName = resultset.getString("recipientName");
					recipientAddress = resultset.getString("recipientAddress");
					recipientCity = resultset.getString("recipientCity");
					courierWeight = resultset.getInt("courierWeight");
					courierStatus = resultset.getString("courierStatus");
					description = resultset.getString("description");
					// orderDate = resultset.getDate(orderDate);
				}*/

				System.out.println("Order Data:");
				System.out.println("-------------------------------------");
				System.out.println("Order Id                        :"
						+ orderId1);
				System.out.println("Customer Id                     :"
						+ customerId);
				// System.out.println("Date Of Order :" + order.getOrderDate());
				System.out.println("Recipient Name                  :"
						+ recipientName);
				System.out.println("Recipient Address               :"
						+ recipientAddress);
				System.out.println("Recipient City (D, P, B, C)     :"
						+ recipientCity);
				System.out.println("Courier Weight                  :"
						+ courierWeight);
				System.out.println("Courier Status                  :"
						+ courierStatus);
				System.out.println("Description                	:"
						+ description);
				System.out.println("Employee ID Assigned            :"
						+ employeeId);
			}
			return resultset;
		} catch (InvalidOrderException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return resultset;

		/*
		 * try { connection = DBConnect.getConnection();
		 * callableStatement=connection.prepareCall(
		 * "{?=call retrieveOrderInfo(?)}");
		 * callableStatement.setInt(2,orderId);
		 * callableStatement.registerOutParameter(1,OracleTypes.STRUCT,
		 * "STERLING_ORDER");
		 * 
		 * 
		 * callableStatement.execute(); Order order =
		 * (Order)callableStatement.getObject(1);
		 * 
		 * System.out.println(callableStatement.getObject(1));
		 * //return(callableStatement.getNString(1).charAt(1));
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

	public ArrayList<Integer> retrieveOrdersNotClosed(int employeeId) throws InvalidEmployeeException,OrderNotAssignedException,SQLException{

		ArrayList<Integer> orderIDS = new ArrayList();
		
			int resultset1;
			connection = DBConnect.getConnection();

			preparedStatement = connection
					.prepareStatement("select * from sterling_employee where employeeid=?");
			preparedStatement.setInt(1, employeeId);
			resultset = preparedStatement.executeQuery();

			if (!resultset.isBeforeFirst()) {
				throw new InvalidEmployeeException("EMPLOYEE DOES NOT EXIST!");
			} else {

				preparedStatement = connection
						.prepareStatement("insert into OrderIdNotClosed select ORDERID from sterling_order WHERE EMPLOYEEID=? AND (COURIERSTATUS='A' OR COURIERSTATUS='P')");
				preparedStatement.setInt(1, employeeId);
				resultset1 = preparedStatement.executeUpdate();
				if (resultset1 == 0) {
					throw new OrderNotAssignedException(
							"Order not assigned to this employee!");
				} else {

					/*
					 * preparedStatement = connection.prepareStatement(
					 * "select * from sterling_employee where employeeid=?");
					 * preparedStatement.setInt(1, employeeId); resultset =
					 * preparedStatement.executeQuery();
					 * 
					 * if(!resultset.isBeforeFirst() ){ throw new
					 * OrderNotAssignedException
					 * ("Order not assigned to this employee!");} else{
					 */
					preparedStatement = connection
							.prepareStatement("select * from OrderIdNotClosed");
					resultset = preparedStatement.executeQuery();

					System.out.println("Order Ids assigned but not closed:");
					while (resultset.next()) {
						orderIDS.add(resultset.getInt("orderid"));
					}
					for (int i = 0; i < orderIDS.size(); i++) {
						System.out.println(orderIDS.get(i));
					}
					preparedStatement = connection
							.prepareStatement("delete from OrderIdNotClosed");
					resultset = preparedStatement.executeQuery();
				}
				return orderIDS;
			}
		
		

	}

	public void retrieveListOfOpenOrders() {

		ArrayList<Integer> orderIDS = new ArrayList();
		try {

			connection = DBConnect.getConnection();

			preparedStatement = connection
					.prepareStatement("insert into OrderIdNotClosed select ORDERID from sterling_order WHERE COURIERSTATUS='A' OR COURIERSTATUS='P'");
			resultset = preparedStatement.executeQuery();
			preparedStatement = connection
					.prepareStatement("select * from OrderIdNotClosed");
			resultset = preparedStatement.executeQuery();
			System.out
					.println("Order Ids assigned but not closed(i.e. Status is Pending/Accepted):");
			while (resultset.next()) {
				orderIDS.add(resultset.getInt("orderid"));
			}
			for (int i = 0; i < orderIDS.size(); i++) {
				System.out.println(orderIDS.get(i));
			}
			preparedStatement = connection
					.prepareStatement("delete from OrderIdNotClosed");
			resultset = preparedStatement.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int saveCustomer(Customer customer) throws SQLException{

		

			String customerName = customer.getCustomerName();
			String address = customer.getAddress();
			String city = customer.getCity();
			String pin = customer.getPin();
			String telephoneNo = customer.getTelephoneNo();
			String emailId = customer.getEmailId();

			java.sql.Date dor = customer.getDateOfRegistration();
			connection = DBConnect.getConnection();
			// System.out.println("Creating statement...");
			CallableStatement cs = null;
			cs = ((Connection) this.connection)
					.prepareCall("{call ADDCUSTOMER(?,?,?,?,?,?,?)}");
			cs.setString(1, customerName);
			cs.setDate(2, dor);
			cs.setString(3, address);
			cs.setString(4, city);
			cs.setString(5, pin);
			cs.setString(6, telephoneNo);
			cs.setString(7, emailId);
			resultset = cs.executeQuery();
			System.out.println("Customer details saved");
		 
		return 0;
	}

	public Customer retrieveCustomerInfo(int customerid) throws SQLException{
		Customer customer = new Customer();
		
			connection = DBConnect.getConnection();

			String sql = "SELECT *FROM Sterling_Customer where CustomerID=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, customerid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("CustomerID");
				String uid = rs.getString("UserID");
				String name = rs.getString("CustomerName");
				Date dateofreg = rs.getDate("DateOfRegistration");
				String add = rs.getString("Address");
				String city = rs.getString("City");
				String pin = rs.getString("Pin");
				String telphNo = rs.getString("TelephoneNo");
				String email = rs.getString("Email");

				customer.setCustomerName(name);
				customer.setDateOfRegistration(dateofreg);
				customer.setAddress(add);
				customer.setCity(city);
				customer.setPin(pin);
				customer.setTelephoneNo(telphNo);
				customer.setEmailId(email);
				// Display values
				System.out.println("ID : " + id);
				System.out.println("UserID : " + uid);
				System.out.println("customer name : " + name);
				System.out.println("Date of Registration : " + dateofreg);
				System.out.println("customer's address : " + add);
				System.out.println("city : " + city);
				System.out.println("pin  : " + pin);
				System.out.println("telephone no  : " + telphNo);
				System.out.println("email  : " + email);

			}
			rs.close();
			return customer;
			
		

	}
	
	public List<Customer> retrieveAllCustomerInfo() throws SQLException{
		
		List customerList = new ArrayList<Customer>();
		
			connection = DBConnect.getConnection();

			String sql = "SELECT *FROM Sterling_Customer";

			PreparedStatement ps = connection.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();

				int id = rs.getInt("CustomerID");
				String uid = rs.getString("UserID");
				String name = rs.getString("CustomerName");
				Date dateofreg = rs.getDate("DateOfRegistration");
				String add = rs.getString("Address");
				String city = rs.getString("City");
				String pin = rs.getString("Pin");
				String telphNo = rs.getString("TelephoneNo");
				String email = rs.getString("Email");

				customer.setCustomerId(id);
				customer.setUserId(uid);
				customer.setCustomerName(name);
				customer.setDateOfRegistration(dateofreg);
				customer.setAddress(add);
				customer.setCity(city);
				customer.setPin(pin);
				customer.setTelephoneNo(telphNo);
				customer.setEmailId(email);
				customerList.add(customer);
				// Display values
				System.out.println("ID : " + id);
				System.out.println("UserID : " + uid);
				System.out.println("customer name : " + name);
				System.out.println("Date of Registration : " + dateofreg);
				System.out.println("customer's address : " + add);
				System.out.println("city : " + city);
				System.out.println("pin  : " + pin);
				System.out.println("telephone no  : " + telphNo);
				System.out.println("email  : " + email);

			}
			rs.close();
			System.out.println("Dao");
			System.out.println(customerList);
			return customerList;

	}

	public void saveDelivery(Delivery delivery, char status) {

		int orderId = delivery.getOrderId();

		java.sql.Date dateOfDel = delivery.getDeliveryDate();

		String remarks = delivery.getRemarks();

		try {
			connection = DBConnect.getConnection();
			callableStatement = connection
					.prepareCall("{call ADDDELIVERY(?,?,?,?)}");
			callableStatement.setInt(1, orderId);
			callableStatement.setDate(2, dateOfDel);
			callableStatement.setString(3, remarks);
			callableStatement.setString(4, String.valueOf(status));
			System.out.println("Saved delivery details");
			callableStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveInvoice(Invoice invoice) {

		int customerId = invoice.getCustomerId();

		int invoiceMonth = invoice.getInvoiceMonth();
		int invoiceYear = invoice.getInvoiceYear();
		int returnValue;

		try {
			connection = DBConnect.getConnection();
			callableStatement = connection
					.prepareCall("{?=call INVOICE_GENERATION(?,?,?)}");
			callableStatement.setInt(2, customerId);
			callableStatement.setInt(3, invoiceYear);
			callableStatement.setInt(4, invoiceMonth);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.execute();
			System.out.println(callableStatement.getInt(1));

			returnValue = callableStatement.getInt(1);
			if (returnValue == -1) {
				throw new InvalidCustomerException(
						"CustomerId is not valid hence order not saved");
			}

			if (returnValue == -2) {
				throw new InvalidDateException("Date Invalid");
			}

			if (returnValue == -3) {
				throw new InvalidOrderException(
						"No Order is placed in the given month");
			}

			if (returnValue == -4) {
				throw new InvoiceGeneratedException("Invoice already generated");
			}

			if (returnValue == -0) {
				throw new SQLException("Database exception has occured");
			}

			if (returnValue > 0) {

				invoice.setAmount(returnValue);
				String invoice_saved = invoice.toString();
				System.out.println(invoice_saved);
			}
		} catch (InvalidCustomerException e) {

			e.printStackTrace();

		}

		catch (InvalidDateException e) {

			e.printStackTrace();

		} catch (InvalidOrderException e) {

			e.printStackTrace();

		}

		catch (InvoiceGeneratedException e) {

			e.printStackTrace();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void saveDistribution(Date dateOfDistribution) {
		int returnValue;
		try {
			connection = DBConnect.getConnection();
			callableStatement = connection
					.prepareCall("{?=call DISTRIBUTION_LIST(?)}");
			callableStatement.setDate(2, dateOfDistribution);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.execute();
			System.out.println(callableStatement.getInt(1));
			returnValue = callableStatement.getInt(1);
			if (returnValue == 1) {
				throw new NoNewOrderException(
						"No orders pending for given date");
			}
			if (returnValue == 0) {
				throw new SQLException("Database Exception");

			}

			if (returnValue == 2) {
				System.out
						.println("Pending Orders assigned to the respective delivery boys");

			}

			// System.out.println("Saved date");
		}

		catch (NoNewOrderException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
