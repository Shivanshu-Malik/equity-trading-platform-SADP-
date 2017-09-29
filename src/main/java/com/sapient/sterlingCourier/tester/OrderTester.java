package com.sapient.sterlingCourier.tester;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sapient.sterlingCourier.dao.SterlingDAO;
import com.sapient.sterlingCourier.entity.Order;
import com.sapient.sterlingCourier.exception.InvalidCityException;
import com.sapient.sterlingCourier.exception.InvalidEmployeeException;
import com.sapient.sterlingCourier.exception.OrderNotAssignedException;
import com.sapient.sterlingCourier.service.DBConnect;

public class OrderTester {

	Order order;
	SterlingDAO sterlingDAO;
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultset=null;
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void readOrderInfo(String recipientName, String recipientAddress, char recipientCity, Date orderDate, float courierWeight,
			String description, int customerId) throws SQLException {

		sterlingDAO = new SterlingDAO();
		order = new Order();
		order.setOrderDate(orderDate);
		order.setRecipientName(recipientName);
		order.setRecipientAddress(recipientAddress);
		order.setRecipientCity(recipientCity);
		order.setCourierWeight(courierWeight);
		order.setDescription(description);

		int orderId = 0;
		try {
			 connection = DBConnect.getConnection();

			 preparedStatement = connection
					.prepareStatement("select seq_orderID.NEXTVAL from DUAL");
		
			 resultset = preparedStatement.executeQuery();
		//	System.out.println("result set " + resultset);

			while (resultset.next()) {
				orderId = resultset.getInt(1);
			}
		} catch (SQLException e1) {
	
			e1.printStackTrace();
		}
		order.setCustomerId(customerId);
		order.setOrderId(orderId);
		//System.out.println("orderId " + orderId);		
		order.setDescription(description);
		order.setCourierStatus('A');
		
			
        CallableStatement callableStatement=null;
		int employeeId=0;
		int val=10;
		try {
			//String regionToCheck=recipientCity.charAt(1);
			connection = DBConnect.getConnection();
			callableStatement=connection.prepareCall("{?=call GetEmployeeIdByRegion(?)}");  
			callableStatement.setString(2,String.valueOf(recipientCity));
			callableStatement.registerOutParameter(1,Types.INTEGER);  
			callableStatement.execute(); 
			System.out.println(callableStatement.getInt(1)); 
			val=callableStatement.getInt(1);
			if(val==0||val==1||val==2){
				System.out.println("no employee found in this region");
				
			throw new InvalidCityException("no employee available in this region");}
				 
			else
			{
				employeeId=0;
			
				order.setEmployeeId(employeeId);

				sterlingDAO.saveOrder(order);
				displayOrderInfo(order);
				}

		} catch (InvalidCityException e) {
			e.printStackTrace();
		}
	    catch (SQLException e) {
			
			System.out.println("exception caught in OrderTester:getEmployeeId ");
			e.printStackTrace();
		}  

		
	
		
		

	}

	public void displayOrderInfo(Order order) {
         
		System.out.println("");
		System.out.println("Courier Order Booking");
		System.out.println("-------------------------------------");
		System.out.println("Customer Id                     :" + order.getCustomerId());
		System.out.println("Date Of Order                   :" + order.getOrderDate());
		System.out.println("Recipient Name                  :" + order.getRecipientName());
		System.out.println("Recipient Address               :" + order.getRecipientAddress());
		System.out.println("Recipient City (D, P, B, C)     :" + order.getRecipientCity());
		System.out.println("Courier Weight                  :" + order.getCourierWeight());
		System.out.println("Description                	:" + order.getDescription());
		//System.out.println("Employee ID Assigned            :"+ order.getEmployeeId());

	}

	public void checkOrderStatus(int orderID) {
		sterlingDAO = new SterlingDAO();
		sterlingDAO.retrieveOrderStatus(orderID);
		
	}
	
	public List getOrderInfo (int orderID) throws SQLException
	{

		sterlingDAO = new SterlingDAO();
		List orderCollection = new  ArrayList();
		ResultSet order1 = sterlingDAO.retrieveOrder(orderID);
		Order order = new Order();
		
			while(order1.next()){
				order.setOrderId((orderID));
				order.setCustomerId(order1.getInt("customerId"));			
				order.setEmployeeId(order1.getInt("employeeId"));
				order.setRecipientName(order1.getString("recipientName"));
				order.setRecipientAddress(order1.getString("recipientAddress"));
				order.setRecipientCity(order1.getString("recipientCity").toCharArray()[0]);
				order.setCourierWeight(order1.getInt("courierWeight"));
				order.setCourierStatus(order1.getString("courierStatus").toCharArray()[0]);
				order.setDescription(order1.getString("description"));
				System.out.println(order);
				orderCollection.add(order);
			}
			System.out.println("Oder collection");
			System.out.println(orderCollection);
			return orderCollection;
		
		
	}

	public Collection<Order> getOrdersNotClosed(int employeeId) throws SQLException,InvalidEmployeeException,OrderNotAssignedException {
		
		sterlingDAO = new SterlingDAO();
		//System.out.println("reached info");
		//System.out.println("employeeId  "+employeeId);
		ArrayList<Integer> orderIDS = sterlingDAO.retrieveOrdersNotClosed(employeeId);
		Collection<Order> orderCollection = new  ArrayList<Order>();
		for(Integer orderID:orderIDS){
			orderCollection.addAll(getOrderInfo(orderID));
		}
		return orderCollection;
		
	}

	public void getListOfOpenOrders() {
		sterlingDAO = new SterlingDAO();
		System.out.println("reached info");
		sterlingDAO.retrieveListOfOpenOrders();
		
	}

}

